/**
 * PLC Sms and Email Notification Vuex Store
 *
 * Vue bussines logic for SMS and Email notification page.
 *
 * @author Radoslaw Jajko <rjajko@softq.pl>
 * @since 2.5.0
 *
 */
const storeAlarmsNotifications = {
	state: {
		pedTemplate: {
			xid: 'PED-PLC',
			alias: '',
			alarmLevel: 1,
			type: 5,
		},
		ehTemplate: {
			id: -1,
			xid: `PLC`,
			alias: `PLC-EventHandler`,
			disabled: false,
			activeRecipients: null,
			sendEscalation: false,
			escalationDelayType: 1,
			escalationDelay: 0,
			escalationRecipients: null,
			sendInactive: false,
			inactiveOverride: false,
			inactiveRecipients: null,
		},
	},

	mutations: {},

	actions: {
		getPlcDataPoints({ dispatch }, datasourceId) {
			return dispatch('requestGet', `/datapoint/${datasourceId}/getAllPlc`);
		},

		//Event Handlers
		_getPlcEventHandlerById({ dispatch }, eventHandlerId) {
			return dispatch('requestGet', `/eventHandler/get/id/${eventHandlerId}`);
		},

		getPlcDataPointConfiguration({ dispatch }, datapointId) {
			return dispatch('requestGet', `/eventHandler/get/plc/datapoint/${datapointId}`);
		},

		deleteEventHandler({ dispatch }, eventHandlerId) {
			return dispatch('requestDelete', `/eventHandler/delete/id/${eventHandlerId}`);
		},

		async updateEventHandlerV2({ dispatch }, payload) {
			let eventHandler = await dispatch('_getPlcEventHandlerById', payload.id);
			if (!!eventHandler) {
				eventHandler.activeRecipients = payload.recipients;
				return dispatch('requestPut', {
					url: `/eventHandler/update/1/${payload.eventTypeRef1}/${payload.eventTypeRef2}`,
					data: eventHandler,
				});
			} else {
				return null;
			}
		},

		//Mailing Lists
		getAllMailingLists({ dispatch }) {
			return dispatch('requestGet', '/mailingList/getAll');
		},

		//Event detectors
		createPointEventDetector({ state, dispatch }, datapointId) {
			let requestData = JSON.parse(JSON.stringify(state.pedTemplate));

			requestData.xid = requestData.xid + `_${datapointId}`;

			return dispatch('requestPost', {
				url: `/eventDetector/set/${datapointId}`,
				data: requestData,
			});
		},

		async createEventHandler({ state, dispatch }, payload) {
			let pedId = await dispatch('createPointEventDetector', payload.datapointId);
			let edId = pedId.id;
			let dpId = payload.datapointId;
			let mlId = payload.mailingListId[0];

			let requestData = JSON.parse(JSON.stringify(state.ehTemplate));
			let type = payload.handlerType === 2 ? 'mail' : 'sms';

			requestData.xid = 'EH_' + requestData.xid + `_${type}_${dpId}_${edId}_${mlId}`;
			requestData.alias = requestData.alias + `_${type}_${dpId}_${edId}_${mlId}`;

			let recipientList = [
				{
					recipientType: 1,
					referenceId: mlId,
					referenceAddress: null,
				},
			];
			if (payload.dual) {
				recipientList.push({
					recipientType: 1,
					referenceId: payload.mailingListId[1],
					referenceAddress: null,
				});
			}

			requestData.activeRecipients = recipientList;
			let eventHandler;

			try {
				eventHandler = await dispatch('requestPost', {
					url: `/eventHandler/set/1/${dpId}/${edId}/${payload.handlerType}`,
					data: requestData,
				});
			} catch (error) {
				throw 'POST request failed!';
			}
			let response = {
				eventTypeId: 1,
				eventTypeRef1: dpId,
				eventTypeRef2: edId,
				id: eventHandler.id,
				xid: eventHandler.xid,
				alias: eventHandler.alias,
				handlerType: eventHandler.handlerType,
				recipients: eventHandler.activeRecipients,
			};
			return response;
		},
	},

	getters: {},
};
export default storeAlarmsNotifications;
