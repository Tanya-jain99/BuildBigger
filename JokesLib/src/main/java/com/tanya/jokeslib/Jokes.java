package com.tanya.jokeslib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jokes {



        static List<String> jokes = new ArrayList<>();
        public  String getJokes(){
            Random random = new Random();
            int index = random.nextInt(jokes.size());
            return jokes.get(index);
        }

        public Jokes(){
            jokes.add("A perfectionist walked into a bar...apparently, the bar wasn’t set high enough.");
            jokes.add("If God wanted us to fly, he would have given us tickets");
            jokes.add("You’ll never be as lazy as whoever named the fireplace.");
            jokes.add("I’d like the window that says “Are you sure you want to do this? OK/Cancel” to pop up less often on my computer and more in my real life. —");
            jokes.add("Q: Where does a one-armed man shop?" + "\n" + "A: At a secondhand store.");
            jokes.add("I own the world's worst thesaurus. Not only is it awful, it's awful.");
            jokes.add("Taking pictures with an iPad is the new fanny pack");
            jokes.add("Did you hear about the monkeys who shared an Amazon account? They were Prime mates.");
            jokes.add("I can give you the cause of anaphylactic shock in a nutshell.");
            jokes.add("Just when I discovered the meaning of life, they changed it.");
            jokes.add("What do fish say when they hit a concrete wall?…Dam!");
            jokes.add("If you think nobody cares if you’re alive, try missing a couple of payments.");
            jokes.add("Ever wonder who the genius is who decided to put fire hydrants in all the good parking spots?");
            jokes.add("Give a man a fish, and he’ll \u2028Instagram it; teach a man to fish, and he’ll still Instagram it.");
        }

}
