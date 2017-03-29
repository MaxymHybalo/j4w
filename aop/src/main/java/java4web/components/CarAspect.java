package java4web.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CarAspect {

    @Before("execution(* java4web.entity.Car.*(..))")
    public void beforeCar(JoinPoint point){
        System.out.println("Before Car call: " + point.getSignature().getName());
    }

    @After("execution(* java4web.entity.Car.*(..))")
    public void afterCar(JoinPoint point){
        System.out.println("After Car call: " + point.getSignature().getName());
    }

    @Around("execution(* java4web.entity.Engine.*(..))")
    public void aroundWheel(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Around Engine: " +point.getSignature().getName());
        point.proceed();
        System.out.println("Proceed: " + point.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* java4web.entity.Car.*(..))", throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println("Throws: " + e.toString());
    }
}
