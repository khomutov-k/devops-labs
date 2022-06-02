# Best Practices 

### 1. Commit early, commit often
Making a small changes and delivering a piece of work fast will help to get feedback swiftly, so it would be easier to address the issues in the beginning.
* People are more likely to carefully review only small batch of changes(~ 200-400 LOC). For tons of code they would probably skip part that they do not understand. 
* Less code to check in less chance to make many severe mistakes in it. 
### 2. Keep builds green 
Address emerging bugs, which fails tests as soon as possible. 
* Try to make it not only single developer responsibility, but whole team

### 3. Build only once
Rebuilding the software for different environments risks inconsistencies being introduced and means you cannot be confident that all previous tests have passed.
Instead, the same build artifact should be promoted through each stage of the CI/CD pipeline and ultimately released to live.
* Build should be versioned and stored in a central artifact repository, such as Nexus, from which it can be pulled down and deployed to each environment.
### 4. Optimize pipeline stages
Stages are an easy way to organize similar jobs, but there may be a few jobs in your pipeline that could safely run in an earlier stage 
without negatively impacting your project if they fail. Consider running these jobs in an earlier stage to speed up CI pipelines

### 5. Make builds fast and simple
Every minute taken off build times is a minute saved for each developer every time they commit. Since CI demands frequent commits, this time can add up.
Martin Fowler discusses a guideline of the ten-minute build that most modern projects can achieve. Since continuous integration demands frequent commits, saving time on commit builds can give developers a lot of time back.

### 6. Test environment should mirror production
Having environment close to production will help to avoid unexpected production bugs. It is crucial to have Staging environment, with production like setting and data.  

### 7. Clean your environment 
Using containers to host environments and run tests makes it easy to spin up and tear down environments for each new deployment,
using an infrastructure-as-code approach to script these steps. Instantiating a new container each time ensures consistency and allows you to scale environments more easily, so you can test multiple builds in parallel if needed.

### 8. Monitor and measure your pipeline 
By analyzing the metrics collected by your CI/CD tool you can identify potential issues and areas for improvement.

* Comparing the number of builds triggered per week, day or hour provides useful insight on how your pipeline infrastructure is used, whether you need to scale it up or down and when the peak load tends to occur.
* Tracking the speed of deployments over time, and monitoring whether they are tending to take longer, can indicate when it's time to invest in performance optimizations.
* Statistics from automated tests can help to determine areas that would benefit from parallelization.
* Reviewing tests results to find those that are routinely ignored can identify potential for streamlining your test coverage.