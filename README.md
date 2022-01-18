
This is a repository containing my solution of the **coding challenge** I've sent to **Europace** for their recruitment process. 

I'm sharing this with you to help you solve the same problem. 

Beware **I got rejected** but I received useful feedback that I'm sharing down here.
Also note that they will tell you should complete the task in 2hr and is not necessary to implement advanced features multi-players etc. Actually this is a **misdirection**, I did it in two hours and this limited the quality of my solution, I could have taken more and that would have made a difference. You should take how much time you want to create the best project that can show your skills. 

It of course depends on how many candidates there are, you can find solutions with very few line of code like [this](https://gist.github.com/gruenewa/5123309) or [this one](https://github.com/smmnloes/EuropaceBowling), and they still get hired. Also, more complex solutions like [this one](https://github.com/DanielW1987/bowling-total-score-calculator). Buy my advice would be to make it as much good as possible, following the feedback on my solution.

The feedback I received: 
```
Positive
- gradle used
- validation regarding too many pins
- model classes
- system tests

Potentials we see
- no readme
- wrong logic:
    - Is the frame a spare the points are 10 + the next throw. 
      Is the frame a strike the points are: 0 + the next 2 throws (not the next 2 frames).
      For example. 8:2, X, 6:4, 5 = 20+20+15 +5=60 and not 20+25+15+5=65. 
      Besides in the last frame you can throw 3 strikes and get 300 points. 
      Maximum points in bowling is 300.
- Methods snake_case instead of camelcase as usual in Java
- model classes
- a lot of logic
- thinking outside the box (how many points were scored in a frame)
- Actually the Player class has all the logic
- Logic in big methods and in conditionals with index
- Example: frame.getRemaining_standing()==0 && frame.getAttempts()<=2
- No unit tests
- Few tested cases 
```

I wish you the best of luck and fun!