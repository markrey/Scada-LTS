/*
 * (c) 2018 Abil'I.T. http://abilit.eu/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.scada_lts.permissions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.scada_lts.permissions.model.EntryDto;
import org.scada_lts.permissions.model.Token;

import java.util.List;

/**
 * Create by at Grzesiek Bylica
 *
 * @autor grzegorz.bylica@gmail.com
 */
public class AuthenticationAclImp implements AuthenticationAcl {

    private static final Log LOG = LogFactory.getLog(AuthenticationAclImp.class);

    private static AuthenticationAclImp instance = null;

    private AuthenticationAclImp() {
        //
    }

    public static AuthenticationAclImp getInstance() {
        if (instance == null) {
            instance = new AuthenticationAclImp();
        }
        return instance;
    }

    @Override
    public boolean checkToken(String token) {
        return false;
    }

    @Override
    public String auth(String user, String passwd) {

            Token result = null;
            try {

                //TODO optimalization
                CloseableHttpClient httpclient = HttpClients.createDefault();

                HttpPost httpPost = new HttpPost(ACLConfig.getInstance().getUrlACL()+"/auth");
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

                String auth = "{" +
                    "\"passwd\":\"" + passwd + "\","+
                    "\"userName\":\"" + user + "\"}";

                StringEntity entity = new StringEntity(auth);
                httpPost.setEntity(entity);

                CloseableHttpResponse response2 = httpclient.execute(httpPost);

                try {

                    ObjectMapper mapper = new ObjectMapper();
                    result = mapper.readValue(response2.getEntity().getContent(), Token.class);

                    HttpEntity entity2 = response2.getEntity();
                    // do something useful with the response body
                    // and ensure it is fully consumed
                    EntityUtils.consume(entity2);
                } finally {
                    response2.close();
                }
            } catch (Exception e) {
                LOG.error(e);
            }

        return result.getAccess_token();

    }
}
