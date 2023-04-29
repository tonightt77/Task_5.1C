package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topStoriesRecyclerView;
    private RecyclerView newsRecyclerViewRow1;
    private RecyclerView newsRecyclerViewRow2;
    private List<TopStory> topStories = Arrays.asList(
            new TopStory("‘Dogfight’: Scary Russia act against US", "The US and Russia are moving increasingly closer to military conflict as planes from both superpowers are jostling over the skies of war-torn Syria — according to a worrying new report.\n" +
                    "\n" +
                    "Lieutenant General Alexus Grynkewich, who leads US Air Forces Central Command said Russian warplanes are “trying to dogfight” with American fighters by flying too close over the region, according to Defence One.\n" +
                    "\n" +
                    "Dogfighting is a term used to describe planes engaging each other in aerial combat.\n" +
                    "\n" +
                    "According to the report, Russian pilots have acted in hostile ways that have US military leaders concerned about the possibilities for miscalculation and escalation.\n" +
                    "\n" +
                    "“The Russians have been “increasingly aggressively against us when our protocols would say we’re supposed to stay … several miles apart and just monitor each other,” said Gen Grynkewich.\n" +
                    "\n" +
                    "The general’s message to his pilots: “Don’t take the bait”.\n" +
                    "\n" +
                    "“The guidance that I’ve given our folks is we’re not going to act like they are,” said Gen Grynkewich.\n" +
                    "\n" +
                    "“We’re going to act in a professional manner and we’re going to try to de-escalate the situation.”", "https://content.api.news/v3/images/bin/25b321a6ec40a5b6cbcfcf17bbced5f5?width=1024"),
            new TopStory("Finally! A Disney remake that doesn’t suck", "Peter Pan Syndrome may not be an actual medical term, but if someone is described as such, you know what kind of person they are.\n" +
                    "\n" +
                    "Eternal youth and forever frolics may sound like fun and games, but we all know that life is only vibrant because it changes. There’s an inherent tragedy in getting stuck in a moment of your life, even if you think it’s the peak.\n" +
                    "\n" +
                    "There’s a quote from an episode of Buffy spin-off Angel that perfectly encapsulates this – “It’s like a song. Now, I can hold a note for a long time, actually I can hold a note forever. But, eventually, that’s just noise. It’s the change we’re listening for. The note coming after and the one after that. That’s what makes it music.”\n" +
                    "\n" +
                    "That line was being said to a character who tried to preserve the moment before his girlfriend dumps him, and that desire to hold onto something instead of facing what’s next is an obvious parallel to the Peter Pan story.\n" +
                    "\n" +
                    "Peter Pan doesn’t want to grow up because he fears change. He fears becoming an adult.", "https://content.api.news/v3/images/bin/5f1bb90103c86a9d9118f993baef98ff?width=1024"),
            new TopStory("Kevvie’s blunt admission in Broncos mauling", "Broncos coach Kevin Walters was reluctant to be too despondent despite admitting his side were flat and Souths made them cop their own medicine in their 32-6 loss at Suncorp Stadium.\n" +
                    "\n" +
                    "Walters believes the Broncos started the game strong, but couldn’t match a ruthless Souths outfit as the game wore on.\n" +
                    "\n" +
                    "“It was a tough night,” Walters said.\n" +
                    "\n" +
                    "Watch every game of every round of the 2023 NRL Telstra Premiership Season LIVE on Kayo Sports. New to Kayo? Start your free trial now >\n" +
                    "\n" +
                    "“I thought we started OK but then we just on the slippery slide for most of the match.\n" +
                    "\n" +
                    "“Even at half-time we had some good field position, we just didn’t take a couple of our opportunities.\n" +
                    "\n" +
                    "“We paid for it in the end by not building any scoreboard pressure and the longer the game went the worse we got.”\n" +
                    "\n" +
                    "Walters conceded the suspended Payne Haas was some big shoes to fill and the Broncos got a taste of what they have been dishing out by Souths.\n" +
                    "\n" +
                    "“I thought we were OK there,” Walters said of the battle of the middle.\n" +
                    "\n" +
                    "“I mean Payne is the best prop in the game, so we are always going to miss him, but I thought we were OK there.", "https://content.api.news/v3/images/bin/863669acf249a0e7abd06ebcc145c83b?width=320"),
            new TopStory("Twist in mum’s mysterious disappearance", "A mother of three from the US allegedly spent time in Dublin with a mystery lover about a month before she went missing.", "https://content.api.news/v3/images/bin/8e6a8ddad8f595ff2adebfeadb3673f1?width=1024"),
            new TopStory("How dogs could tell if you have Covid-19", "Scent dogs can smell if a person has Covid-19 “in a matter of seconds”, a new study has revealed, with researchers excited at the discovery.", "https://content.api.news/v3/images/bin/e5538b3f38ce69fdfb13da5bf015bb42?width=1024"),
            new TopStory("Twist in nation’s war against AI craze", "Despite calls from Elon Musk to pause “AI experiments”, one nation has backflipped on its pledge to halt access to a controversial app.", "https://content.api.news/v3/images/bin/0edd3fbffa04c48d895df6600fc85fb0?width=1024")
    );

    private List<News> newsList = Arrays.asList(
            new News("The Simpsons character star regrets playing", "The Simpsons star Hank Azaria has revealed the character he regrets playing on the animated series.", "https://content.api.news/v3/images/bin/fb8a901e36ddb158f24298d1fe380a2c?width=320"),
            new News("China’s brutal move against Australia", "The first of Australia’s $368 billion nuclear submarine fleet won’t be operational before the 2040s. But China’s not sitting idly by.", "https://content.api.news/v3/images/bin/a1940c1b14862a1cdc0725b380847173?width=320"),
            new News("AFL stunned by Greene’s ‘amazing’ matchwinner", "Toby Greene has done it again, with the GWS Giants captain downing the Sydney Swans with a superb last-gasp matchwinner.", "https://content.api.news/v3/images/bin/b8ea9abba9c1dc6ff995532f7b706da6?width=320"),
            new News("Prince Harry goes nuclear against family", "As if Prince Harry hasn’t shared enough about his family already, he has now released 31 pages dragging various royals through the mud.", "https://content.api.news/v3/images/bin/a1ef36286dbadad968a2408be9a8c0e1?width=320"),
            new News("Prince Harry goes nuclear against family", "As if Prince Harry hasn’t shared enough about his family already, he has now released 31 pages dragging various royals through the mud.", "https://content.api.news/v3/images/bin/a1ef36286dbadad968a2408be9a8c0e1?width=320"),
            new News("‘Naked, drunk’ Aussie mobbed in Indonesia", "New details are emerging of an alleged drunken rampage by a young Aussie that left Indonesian locals so angry they allegedly threatened to burn down a hotel.","https://content.api.news/v3/images/bin/7405ec95e6eb13718df0afc8468876b9?width=320"),
            new News("Florence Pugh’s drastic transformation", "Marvel actress Florence Pugh has a bold new look which has been described as “absolutely incredible”.", "https://content.api.news/v3/images/bin/0f48be728bb3024513c744cf2f7c15ca?width=320"),
            new News("News 3", "News 3 description", "https://content.api.news/v3/images/bin/04f1286eb96ee16b65bc5de29e41fce3?width=320"),
            new News("News 3", "News 3 description", "https://content.api.news/v3/images/bin/04f1286eb96ee16b65bc5de29e41fce3?width=320")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find and initialize RecyclerViews for top stories and news rows
        topStoriesRecyclerView = findViewById(R.id.top_story);
        newsRecyclerViewRow1 = findViewById(R.id.news_recycler_view_row1);
        newsRecyclerViewRow2 = findViewById(R.id.news_recycler_view_row2);
        // Set layout managers for RecyclerViews
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        newsRecyclerViewRow1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        newsRecyclerViewRow2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Create and set TopStoryAdapter with click listener
        TopStoryAdapter topStoryAdapter = new TopStoryAdapter(topStories, new TopStoryAdapter.OnTopStoryClickListener() {
            @Override
            public void onTopStoryClick(TopStory topStory) {
                // Create a News object from the clicked TopStory
                News news = new News(topStory.getTitle(), topStory.getDescription(), topStory.getImageUrl());
                // Create a NewsDetailFragment with the News object
                Fragment newsDetailFragment = NewsDetailFragment.newInstance(news);
                // Replace the fragment_container with the NewsDetailFragment and add the transaction to the back stack
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, newsDetailFragment)
                        .addToBackStack(null)
                        .commit();
                // Hide top stories section
                setTopStoryVisibility(View.GONE);
            }

        });
        // Create and set NewsAdapters for news rows
        NewsAdapter newsAdapterRow1 = new NewsAdapter(newsList.subList(0, 4));
        NewsAdapter newsAdapterRow2 = new NewsAdapter(newsList.subList(4, 8));

        topStoriesRecyclerView.setAdapter(topStoryAdapter);
        newsRecyclerViewRow1.setAdapter(newsAdapterRow1);
        newsRecyclerViewRow2.setAdapter(newsAdapterRow2);
    }
    // Method to set the visibility of the top stories section
    public void setTopStoryVisibility(int visibility) {
        View topStoryView = findViewById(R.id.top_story);
        if (topStoryView != null) {
            topStoryView.setVisibility(visibility);
        }
        TextView topStoriesTitle = findViewById(R.id.top_stories_title);
        if (topStoriesTitle != null) {
            topStoriesTitle.setVisibility(visibility);
        }
    }

    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            // Show top stories section if there are fragments in the back stack
            setTopStoryVisibility(View.VISIBLE);
        }
        super.onBackPressed();
    }
}
