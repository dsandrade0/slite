package info.dsandrade

import info.dsandrade.handler.FrontController
import jakarta.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.{Request, Server, ServerConnector}
import org.eclipse.jetty.util.thread.QueuedThreadPool
import org.slf4j.{Logger, LoggerFactory}


object SliteMain {
  val LOG: Logger = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]): Unit = {
    start(args)
  }

  def start(args: Array[String]): Unit = {

    LOG.info("Startando aplicação")

    val threadPool = QueuedThreadPool(500, 20)
    threadPool.setName("slite-client-thread")

    
    //Cria a instancia do servidor na porta 9999
    val server = Server(threadPool)
    val serverConnector = ServerConnector(server)
    serverConnector.setPort(9999)
    server.setConnectors(Array(serverConnector))

    server.setHandler(FrontController())
    server.start()
  }

}
