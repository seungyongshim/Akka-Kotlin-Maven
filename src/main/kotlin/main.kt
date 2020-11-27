import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.UntypedAbstractActor
import akka.actor.setup.ActorSystemSetup

fun main(args: Array<String>) {
    val actorSystemSetup = ActorSystemSetup.create()
    val actorSystem = ActorSystem.create("hello", actorSystemSetup);
    val pingActor = actorSystem.actorOf(Props.create { PingActor() })
    pingActor.tell("Hello World", null)
    actorSystem.terminate()
}

class PingActor : UntypedAbstractActor() {
    override fun onReceive(message: Any?) {
        context.system.log().info("$message")
    }
}



