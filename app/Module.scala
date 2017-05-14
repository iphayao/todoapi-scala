import javax.inject._
import com.google.inject.AbstractModule
import play.api.{ Configuration, Environment }
import models._

class Module( environment: Environment, configuration: Configuration) extends AbstractModule {
    def configure() = {
        bind(classOf[TodoRepository]).to(classOf[TodoRepositoryImp]).asEagerSingleton
    }
}
