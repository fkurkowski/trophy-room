import com.fkurkowski.trophy.controller.TrophyServlet
import com.fkurkowski.trophy.domain.Tables
import com.mchange.v2.c3p0.ComboPooledDataSource
import com.typesafe.scalalogging.LazyLogging
import org.scalatra._
import javax.servlet.ServletContext
import slick.driver.H2Driver.api.Database

class ScalatraBootstrap extends LifeCycle with LazyLogging {

  val cpds = new ComboPooledDataSource
  logger.info("Created connection pool with c3p0")

  override def init(context: ServletContext) {
    val db = Database.forDataSource(cpds);
    db.run(Tables.setup)
    context.mount(new TrophyServlet(db), "/*")
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    logger.info("Closing connection pool")
    cpds.close()
  }
}
