package agena.sft.com.example.exam.Aspect;

import agena.sft.com.example.exam.Entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("execution(* agena.sft.com.example.exam.Services.*.*.get(..))")
    public List<Project> profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        List<Project> obj = (List<Project>) pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

}
