package org.rrl.testpixmap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TestPixmap extends ApplicationAdapter {
    private Sound sound_applause;
    private SpriteBatch batch;
    private Texture texture1, texture2, texture_mix;
    private boolean playSound = true;

    @Override
    public void create() {
        sound_applause = Gdx.audio.newSound(Gdx.files.internal("applause.wav"));
        batch = new SpriteBatch();
        Pixmap pixmap1 = new Pixmap(Gdx.files.internal("image1.png"));
        texture1 = new Texture(pixmap1);
        Pixmap pixmap2 = new Pixmap(Gdx.files.internal("image2.png"));
        texture2 = new Texture(pixmap2);
        pixmap1.drawPixmap(pixmap2, 0, 0);
        texture_mix = new Texture(pixmap1);
        pixmap1.dispose();
        pixmap2.dispose();
    }

    @Override
    public void render() {
        if (playSound) {
            playSound = false;
            sound_applause.play();
        }
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(texture1, 50, 210);
        batch.draw(texture2, 250, 210);
        batch.draw(texture_mix, 450, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture1.dispose();
        texture2.dispose();
        texture_mix.dispose();
        sound_applause.dispose();
    }
}
