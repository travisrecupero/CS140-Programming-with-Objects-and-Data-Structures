# Lab01 - Due Tonight by 11:59 pm

An introduction to terminal commands, basic java programming, and git commands.

Welcome!

You are working in a Linux lab; the operating system on these computers is the Ubuntu variant of Linux. Enter your Binghamton user ID and PODS password to log on - if you are unable to log on, consult the TA. This <a href="http://cs.binghamton.edu/~mhems1/cs140s17/">website</a> also has some materials you may find helpful over the course of the semester. It is from another TA that used to help teach the course, so just keep in mind that there may be some outdated information. For instance, we will be using Java 9 instead of Java 8.

<h1>Some Directory setup</h1>
For the beginning part of the course, we will be working from the terminal and coding in a simple text editor. Open up a terminal by clicking the black prompt icon in the bottom icon bar. Type in the command <b>rm -rf .cache</b>. This executes the <b>rm</b> command to remove the directory named .cache. Removing this directory is done to provide more memory space on your account. Next run the command  <b>mkdir -p cs140/labs</b> which creates a labs directory within a cs140 directory. Next change to the <b>labs</b> directory with the command  <b>cd cs140/labs</b>. Notice your prompt has changed to reflect the directory change. More about the shell can be found <a href="http://cs.binghamton.edu/~mhems1/cs140s17/pitfalls/shell.html">here</a>.

<h1>Github: Set up and Cloning Lab01</h1>
We will be using Github to submit your labs and assignments throughout this course. You will need a Github account, so if you don't have one already, go to <a href="https://github.com/">Github</a> and sign up.

<br>Once you have signed up for an account, <b><a href = "https://goo.gl/forms/5mxqS9u9F1eOxGnD3">fill out and submit this google form</a></b></br>.  

Completing the form will be part of your grade for this lab.

You've probably noticed that when you accepted the lab, it took a little time to set up the repository for you. When the set up is complete, it should give you a URL.
  
Go to the repository that has been made for you at the URL, and hit the green <b>Clone or download</b> button. Be sure to clone with HTTPS, copying the link provided to you. We are about to clone the repository to your linux computer so you can begin interacting with the code. You may notice that some starter files have been provided for you.

Now, go back to the terminal. Make sure you are in the cs140/labs directory. We need to set up our git credientials. Enter then following two commands to the terminal:
<br><b>git config --global user.name "Firstname Lastname"</b></br>
<br><b>git config --global user.email "email@binghamton.edu"</b></br>

Next we clone the repository from GitHub by running the following git command:
<b>git clone URL </b>

Where URL is the URL that you copied from GitHub's green clone or download button. 

Once the cloning is complete, run the command <b>ls</b>, which lists all directories and files in your current directory. You should see that a new directory has been created for you <b>lab01-GIT-USERNAME_HERE</b>. Go ahead and <b>cd</b> into it. 
<br>💡If you get stuck along the way, please ask a TA to help you. Cloning assignments will be done for the rest of the course.💡</br>

Congratulations! You just cloned your first assignment for the class, and are ready to code.

<h1>Onto the lab: Baby Steps</h1>
Go ahead and open up <b>Hello.java</b>, which has been included in your repository. Whenever you want to create a new file or open an existing one, you would open the text editor with the name of the file like so:
<br><b>gedit filename.java &</b></br>

<b>Internalize this small program and how it is written. There will be a quiz on something similar in class tomorrow (Friday).</b> 

With this minimal but complete program, we now must compile and run it. You'll need to learn the two commands to compile and run Java programs. To compile, run <b>javac -d . Hello.java</b>. To run, execute <b>java lab01.Hello</b> . You should see the text *"Hello, World!"* in the console. A more detailed explanation of what you have just done can be found <a href="http://cs.binghamton.edu/~mhems1/cs140s17/pitfalls/hello.html">here</a>.

<h1>Some Classes</h1>
The basic building block of Java programs is <b>classes</b>. Classes model real-world objects where the class's variables model an object's data and the class's methods model actions available on that object.

We have provided two classes for you, <b>Loan.java</b> and <b>Loanee.java</b>
-Look over Loan.java, noting the variables and methods contained in the class. Use the comments to assist your understanding.

We can accomplish more when objects interact. The Loanee class will model a person taking out a Loan.
-Read the provided code in Loanee.java and then respond to the two <b>TODOs</b> that have to do with completing given methods. Read the comments to understand how the method should behave.

<h1>Taking the code for a spin</h1>
We've written two classes so now we want to actually use those classes to accomplish some tasks. For now, we just want to do some simple tests of the canPayLoan method you've implemented.  

We have provided a simple tester, the LoanSimulation.java file. Notice the tester is basically a main method that uses the Loan and Loanee classes we have discussed above.

Now compile and run your code with the following two commands:

javac -d . *.java
<br>java lab01.LoanSimulation</br>
<br>Note the similarities between these commands and those you issued for Hello.java. More about this <a href="http://cs.binghamton.edu/~mhems1/cs140s17/pitfalls/compiling.html">here.</a></br>

<h1>Submitting the lab to GitHub</h1>
In this and future labs, we will use Github Classroom repositories. You have already forked this repository when you accepted the GitHub classroom link. That makes a copy of the repository, free for you to make changes. Then you cloned your forked repository to get a working copy onto this machine.  

Now that we have made local changes to our working copy, let's commit those changes to the repository:

⚠️ Note: These commands all presume that your current working directory is within the directory tracked by git.

<b>git commit -a -m "first commit"</b>
The -a says that git should add all tracked files with changes to your commit, and the -m says the next string contains the commit message.

What about untracked files? Run the following commands:

<b>touch dummy.txt</b>
<br><b>git status</b></br>
You'll notice that git tells us that information.txt is an untracked file. That means it's not being tracked by the repository. Let's fix that by adding it.

<b>git add dummy.txt</b>
<br><b>git commit -m "Added a dummy file"</b></br>
⚠️ You must add any new files you create to the repository with the git add command or they will not upload to the repo, and your code will not work.

Once we've made the commits for a given coding session, we need to add those to the repository by performing a push:

<b>git push</b>  
Now, let's say we don't want dummy.txt in the repository anymore. How can we remove it?

<b>git rm dummy.txt</b>  
<b>git commit -am "Removed a dummy file"</b>  
<b>git push</b>  
Lastly, the next time we begin a coding session, we will need to pull to get an updated working copy.

<b>git pull</b>  
This will allow you to keep your code in the lab and on your own computer synchronized if you want to work outside of lab.

Lastly we are going to make our final commit. You will need to do this when your submission is ready for grading.

<b>git commit --allow-empty -a -m "completed lab01"</b>  
<b>git push</b>  
The --allow-empty option makes it possible to make a commit without having made any changes. This will enable you to just update the comment.

💡 You can commit as often as you like, and revert your code to any previous commit using the commit hash. The commit hash is a long number that identifies a specific version of your code. I recommending making commits often with a comment describing the state of your code. To find your most recent commit hash, use the following command:

git rev-parse HEAD  
You should get a long, strange looking number:

0a8d7e3dfca995dfd470552cde7a065f82f97bd8

To complete your submission, you must copy and paste this number into mycourses. Go to MyCourses, select CS140-A0, and go to Content-> Submissions-> Labs. Select lab01, and where it says text submission, paste your commit hash. The TAs will only grade your submission that corresponds to the hash you submitted. You can update this as often as you like until the deadline.

⚠️ You MUST submit the commit hash on mycourses before the deadline to be considered on time even if your lab is completely working before the deadline. ⚠️

That's it! We've completed our work for this lab. We will use this submission process for all subsequent labs and assignments.

💡 Useful git references:

https://guides.github.com/introduction/flow/  
https://help.github.com  
https://git-scm.com/doc  

