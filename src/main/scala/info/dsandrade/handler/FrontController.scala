package info.dsandrade.handler


import jakarta.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.{Request, Response}
import org.slf4j.LoggerFactory


class FrontController extends AbstractHandler {
  val LOG = LoggerFactory.getLogger(getClass)
  override def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse): Unit = {
    //TODO implementar conceito de FrontConroller
    //https://www.geeksforgeeks.org/front-controller-design-pattern/

    LOG.info("Base Request - {}", baseRequest)
    LOG.info("Target - {}", target)
    LOG.info("Request - {}", request)
    LOG.info("Response - {}", response)

    //Necessario para fechar a chamada http
    baseRequest.setHandled(true)

    response.setContentType("application/json")
    response.setStatus(200)
    response.getWriter().write("{status: OK}\n")

  }

}
