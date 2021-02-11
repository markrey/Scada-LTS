export const textRenderesTemplates = [
    {
        format: "0.0",
        suffix: "",
        typeName: 'textRendererAnalog',
        metaText: '',
        def: {
            id: 0,
            name: 'textRendererAnalog',
            exportName: "ANALOG",
            nameKey: 'textRenderer.analog',
            supportedDataTypes: [3]
        },
        colour: null
    },
    {
        zeroLabel: '',
        zeroColour: '',
        oneLabel: '',
        oneColour: '',
        typeName: 'textRendererBinary',
        def: {
            id: 0,
            name: 'textRendererBinary',
            exportName: "BINARY",
            nameKey: 'textRenderer.binary',
            supportedDataTypes: [1]
        },
        colour: null,
        metaText: null,
    },
    {
        multistateValues: [],
        typeName: 'textRendererMultistate',
        def: {
            id: 0,
            name: 'textRendererMultistate',
            exportName: "MULTISTATE",
            nameKey: 'textRenderer.multistate',
            supportedDataTypes: [2]
        },
        colour: null,
        metaText: null,
    },
    {
        suffix: "",
        typeName: 'textRendererPlain',
        metaText: null,
        def: {
            id: 0,
            name: 'textRendererPlain',
            exportName: "PLAIN",
            nameKey: 'textRenderer.plain',
            supportedDataTypes: [1,2,3,4]
        },
        colour: null,
    },
    {
        format: "",
        rangeValues: [],
        typeName: 'textRendererRange',
        def: {
            id: 0,
            name: 'textRendererRange',
            exportName: "RANGE",
            nameKey: 'textRenderer.range',
            supportedDataTypes: [3]
        },
        colour: null,
        metaText: null
    },
    {
        format: "",
        conversionExponent: 0,
        typeName: 'textRendererTime',
        def: {
            id: 0,
            name: 'textRendererTime',
            exportName: "TIME",
            nameKey: 'textRenderer.time',
            supportedDataTypes: [3]
        },
        colour: null,
        metaText: null,
    },
]

export const chartRenderersTemplates = [
    {
        limit: 2,
        typeName: 'chartRendererTable',
        def: {
            id: 0,
            name: 'chartRendererTable',
            exportName: 'TABLE',
            nameKey: 'chartRenderer.table',
            supportedDataTypes: [1,2,3,4]
        }
    },
    {
        timePeriod: 2,
        numberOfPeriods: 1,
        typeName: 'chartRendererImage',
        def: {
            id: 0,
            name: 'chartRendererImage',
            exportName: 'IMAGE',
            nameKey: 'chartRenderer.image',
            supportedDataTypes: [1,2,3]
        },
        duration: 60000,
        startTime: undefined,
    },
    {
        timePeriod: 2,
        numberOfPeriods: 1,
        includeSum: false,
        typeName: 'chartRendererStats',
        def: {
            id: 0,
            name: 'chartRendererStats',
            exportName: 'STATS',
            nameKey: 'chartRenderer.statistics',
            supportedDataTypes: [1,2,3,4]
        },
        duration: 60000,
        startTime: undefined,
    },
]

export const eventRenderersTemplates = [
    {},
    {
        zeroShortLabel: "",
        zeroLongLabel: "",
        zeroColour: "#000000",
        oneShortLabel: "",
        oneLongLabel: "",
        oneColour: "#000000",
        typeName: "eventTextRendererBinary",
        def: {
            id: 0,
            name: "eventTextRendererBinary",
            exportName: "EVENT_BINARY",
            nameKey: "textRenderer.binary",
            supportedDataTypes: [1]
        },
        colour: null,
        metaShortText: null,
        metaLongText: null
    },
    {
        multistateEventValues: [ ],
        typeName: "eventTextRendererMultistate",
        def: {
            id: 0,
            name: "eventTextRendererMultistate",
            exportName: "EVENT_MULTISTATE",
            nameKey: "textRenderer.multistate",
            supportedDataTypes: [2]
        },
        colour: null,
        metaShortText: null,
        metaLongText: null
    },
    {},
    {
        rangeEventValues: [ ],
        typeName: "eventTextRendererRange",
        def: {
            id: 0,
            name: "eventTextRendererRange",
            exportName: "EVENT_RANGE",
            nameKey: "textRenderer.range",
            supportedDataTypes: [3]
        },
        colour: null,
        metaShortText: null,
        metaLongText: null
    }
]

export const eventDetectorTemplates = [
    {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 1,
        
        duration: 0,
        durationType: 1,
        limit: 0.0,
    },
    {    
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 2,
        
        duration: 0,
        durationType: 1,
        limit: 0.0,
    }, 
    {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 3,

        duration: 0,
        durationType: 1,
        binaryState: false,
    }, 
    {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 4,

        duration: 0,
        durationType: 1,
        multistateState: 0,
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 5
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 6,

        duration: 0,
        durationType: 1,
        changeCount: 2,
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 7,

        duration: 0,
        durationType: 1,
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 8,

        duration: 0,
        durationType: 1,
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 9,

        duration: 0,
        durationType: 1,
        alphanumericState: null,
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 10,

        duration: 0,
        durationType: 1,
        weight: 0,
        positiveLimit: 1,
    }, {
        id: -1,
        xid: "",
        alias: "",
        alarmLevel: 0,
        detectorType: 11,

        duration: 0,
        durationType: 1,
        weight: 0,
        negativeLimit: 1,
    },
]
