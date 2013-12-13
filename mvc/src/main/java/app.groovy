
@Grab(group='com.gmongo', module='gmongo', version='1.0')
import com.gmongo.GMongo

//@bingo 陈兵
//@2013-12-13


@RestController
class ThisWillActuallyRun {


	@Autowired
	private MyService myService;

	def mongo = new GMongo()


	def db = mongo.getDB("gmongo")

    @RequestMapping("/")
    String home(){

       return "Hello World! 222\n"
    }

    @RequestMapping("/home")
    String home2(){

       return "Hello World! home\n"
    } 

    @RequestMapping("/insertDB/{name}")
    String insertDB(@PathVariable("name") String theOwner){
		db.languages.insert([name: theOwner])
       return "insert languages ok !\n"
    } 

    @RequestMapping("/insertProduct/{name}")
    String insertProduct(@PathVariable("name") String theName){
		return myService.save(theName)
    }
    

 	@RequestMapping("/query/{name}")
    String query(@PathVariable("name") String theName){
		return db.orders.findOne()
    }
    

}



@Service
class MyService {

	def mongo = new GMongo()

	def db = mongo.getDB("gmongo")

	public String sayWorld() {
		return "World!";
	}

	String save(String product) {
		db.orders.insert(name: product)

		return "insert $product ok !";
	}


}

