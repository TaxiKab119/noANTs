## :sparkles: TLDR :sparkles:
noANTs is an Android app to record and challenge automatic negative thoughts. Science informed by Cognitive Behavioural Therapy, UI inspired by noname. I built this in 24hrs solo during my _first_ hackathon [DeltaHacks](https://deltahacks-x.devpost.com/) and it excitingly :checkered_flag: **won the Google Student Developer Club Challenge for best hack using Google technology to address one of the United Nations Sustainable Development Goals** :checkered_flag:. Check out my [devpost](https://devpost.com/software/no-more-automatic-thoughts) for pictures and video of the functionality.

## Inspiration
I've always been inspired by the notion that even as just one person you can make a difference. I really took this to heart at DeltaHacks in my attempt to individually create a product that could help individuals struggling with their mental health by providing actionable and well-studied techniques in a digestible little Android app. As a previous neuroscientist, my educational background and research in addiction medicine has shown me the incredible need for more accessible tools for addressing mental health as well as the power of simple but elegant solutions to make mental health more approachable. I chose to employ a technique used in Cognitive Behavioral Therapy (CBT), one of (if not the most) well-studied mental health intervention in psychological and medical research. This technique is called automatic negative thought (ANT) records.
Central to CBT is the principle that psychological problems are based, in part, on faulty/unhelpful thinking and behavior patterns. People suffering from psychological problems can learn better ways of coping with them, thereby relieving their symptoms and becoming more effective in their lives. CBT treatment often involves efforts to change thinking patterns and challenge distorted thinking, thereby enhancing problem-solving and allowing individuals to feel empowered to improve their mental health. CBT automatic negative thought (ANT) records and CBT thought challenging records are widely used by mental health workers to provide a structured way for patients to keep track of their automatic negative thinking and challenge these thoughts to approach their life with greater objectivity and fairness to their well-being.

See more about the widely studied Cognitive Behavioral Therapy at this American Psycological Association [link](https://www.apa.org/ptsd-guideline/patients-and-families/cognitive-behavioral)

  ### Given the app's focus on finding objectivity in a sea of negative thinking, I really wanted the UI to be simple and direct. This lead me to take heavy inspiration from a familiar and nostalgic brand recognized for its      bold simplicity, objectivity and elegance - "noname". [link](https://www.noname.ca/)

This is how I arrived at noANTs - i.e., no (more) automatic negative thoughts

## What it does
noANTs is a simple and elegant solution to tracking and challenging automatic negative thoughts (ANTs). It combines worksheets from research and clinical practice into a more modern Android application to encourage accessibility of automatic negative thought tracking.

See [McGill worksheet](https://www.mcgill.ca/counselling/files/counselling/thought_record_sheet_0.pdf) which one of many resources which informed some of questions in the app.

## How I built it
I really wanted to build something that many people would be able to access and an Android application just made the most sense for something where you may need to track your thoughts on the bus, at school, at work or at home.

I challenged myself to utilize the newest technologies Android has to offer, building the app **entirely in Jetpack Compose**. I had some familiarity using the older Fragment-based navigation in the past but I really wanted to learn how to utilize the **Compose Navigation** and I can excitedly say I implemented it successfully.

I also used **Room**, a data persistence library which provided an abstraction layer for the SQLite database I needed to store the thought records which the user generates.

## Challenges I ran into
This is my first ever hackathon and I wanted to challenge myself to build a project alone to truly test my limits in a time crunch. I surely tested them! Designing this app with a strict adherence to NoName's branding meant that I needed to get creative making many custom components from scratch to fit the UI style I was going for. This made even ostensibly simple tasks like creating a slider, incredibly difficult, but rewarding in the end.

I also had far loftier goals with how much I wanted to accomplish, with aspirations of creating a detailed progress screen, an export functionality to share with a therapist/mental-health support worker, editing and deleting and more. I am nevertheless incredibly proud to showcase a functional app that I truly believe could make a significant difference in people's lives and I learned to prioritize creating and MVP which I would love to continue building upon in the future.

## Accomplishments that I'm proud of
I am so proud of the hours of work I put into something I can truly say I am passionate about. There are few things I think should be valued more than an individual's mental health, and knowing that my contribution could make a difference to someone struggling with unhelpful/negative thinking patterns, which I myself often struggle with, makes the sleep deprivation and hours of banging my head against the keyboard eternally worthwhile.

## What I learned
Being under a significant time crunch for DeltaHacks challenged me to be as frugal as possible with my time and design strategies. I think what I found most valuable about both the time crunch, my inexperience in software development, and working solo was that it forced me to come up with the simplest solution possible to a real problem. I think this mentality should be approached more often, especially in tech. There is no doubt a place, and an incredible allure to deeply complex solutions with tons of engineers and technologies, but I think being forced to innovate under constraints like mine reminded me of the work even one person can do to drive positive change.

## What's next for noANTs
I have countless ideas on how to improve the app to be more accessible and helpful to everyone. This would start with my lofty goals as described in the challenge section, but I would also love to extend this app to IOS users as well. I'm itching to learn cross-platform tools like **KMM and React Native** and I think this would be a welcomed challenge to do so.
