package api.my_market_advisory.configuration;

public class MarketConfigurationTest extends AbstractTestNGSpringContextTests {
   
    @Autowire
    MarketServiceTest

    @DataProvider
    Object[][] configurations() {
        return new Object[][] {
        {MarketComponentConfig.class},
        {IEXComponentConfig.class}};
    }
    
    void runMethod(Class<?> config) {
        if(config instanceOf MarketComponentConfig || config instanceOf IEXCloudComponent) {
            ApplicationContext context = new AnnotationConfigApplicationContext(config);
        } 
        else {
            throw new RuntimeException();
        }
        
        
    }
}