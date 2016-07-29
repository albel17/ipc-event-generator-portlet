import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class EventGeneratorPortlet extends MVCPortlet {

    @ProcessAction(name = "processEvent")
    public void process(ActionRequest request, ActionResponse response) {
        System.out.println("Send data.");

        /**
         * Get sample text from UI
         */

        String sampleText = ParamUtil.getString(request, "sampleText", "");

        /**
         * Refer portlet.xml
         */
        QName qName = new QName("http://proliferay.com/events", "ipc-text");
        response.setEvent(qName, sampleText);
    }

}
