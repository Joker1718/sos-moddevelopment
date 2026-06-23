/*     */ package cutscene;
/*     */ 
/*     */ import game.audio.MusicFactory;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.KeyBoard;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundStream;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.Fire;
/*     */ import snake2d.util.light.PointLight;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.spritecomposer.Initer;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CutScene
/*     */   extends CORE_STATE
/*     */ {
/*     */   public static CORE_STATE.Constructor make(final Json data, final Json text, final CORE_STATE.Constructor after) {
/*  40 */     return new CORE_STATE.Constructor() {
/*  41 */         CutScene e = null;
/*     */ 
/*     */         
/*     */         public CORE_STATE getState() {
/*  45 */           (new CORE.GlJob()
/*     */             {
/*     */               public void doJob() {
/*  48 */                 if (PATHS.CACHE_DATA().exists("cutscene"))
/*  49 */                   PATHS.CACHE_DATA().delete("cutscene"); 
/*  50 */                 (new Initer()
/*     */                   {
/*     */                     public void createAssets() throws IOException
/*     */                     {
/*  54 */                       CORE.getSoundCore().stopAllSounds();
/*  55 */                       CORE.getSoundCore().disposeSounds();
/*  56 */                       (CutScene.null.null.access$0(CutScene.null.null.this)).e = new CutScene(data, text, after);
/*     */                     }
/*  58 */                   }).get("cutscene", PATHS.textureSize(), 0);
/*     */               }
/*  62 */             }).perform();
/*     */           
/*  64 */           return this.e;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  71 */   private static CharSequence ¤¤desc = "Hold left mouse button to skip.";
/*  72 */   private static CharSequence ¤¤loading = "Loading...";
/*     */   
/*     */   static {
/*  75 */     D.ts(CutScene.class);
/*     */   }
/*     */   
/*  78 */   private double timer = 0.0D;
/*     */   private final SoundStream music;
/*     */   private final double ll;
/*  81 */   private double quitTimer = 0.0D;
/*     */   
/*     */   private boolean quit = false;
/*  84 */   private static double quitTime = 2.0D;
/*     */   
/*  86 */   private final GuiSection section = new GuiSection();
/*     */   
/*     */   private final CORE_STATE.Constructor after;
/*     */   private final AmbientLight light;
/*  90 */   private final Fire fire = new Fire(4.0D);
/*  91 */   private final PointLight fire2 = new PointLight(0.5D, 0.5D, 0.5D);
/*     */   private final SPRITE image;
/*     */   private final Text text;
/*     */   
/*     */   private CutScene(Json json, Json jtext, CORE_STATE.Constructor after) throws IOException {
/*  96 */     this.after = after;
/*     */ 
/*     */     
/*  99 */     this.light = new AmbientLight(1.0D, 1.0D, 1.0D, 180.0F, 45.0F);
/* 100 */     CORE.getSoundCore().disposeSounds();
/* 101 */     MusicFactory sf = new MusicFactory();
/*     */     
/* 103 */     this.music = (SoundStream)sf.read(json).get(0);
/* 104 */     this.ll = this.music.getLengthInSeconds();
/*     */     
/* 106 */     this.image = UI.image().get(json);
/*     */ 
/*     */ 
/*     */     
/* 110 */     CharSequence tt = jtext.text("BODY");
/* 111 */     this.text = new Text(Math.max(500, this.image.height()), tt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     this.section.body().setDim(C.DIM().width(), Math.max(this.image.height(), 500));
/*     */     
/* 122 */     GTextR title = new GTextR(new GText((UI.FONT()).H2, jtext.text("TITLE")));
/* 123 */     title.text().lablify();
/* 124 */     title.body().centerX(C.DIM());
/* 125 */     title.body().moveY2((this.section.body().y1() - 32));
/* 126 */     this.section.add((RENDEROBJ)title);
/*     */ 
/*     */     
/* 129 */     GTextR desc = new GTextR(new GText((UI.FONT()).S, ¤¤desc));
/* 130 */     desc.text().lablifySub();
/* 131 */     desc.body().centerX(C.DIM());
/* 132 */     desc.body().moveY1((this.section.body().y2() + 32));
/* 133 */     this.section.add((RENDEROBJ)desc);
/* 134 */     this.section.body().centerIn(C.DIM());
/*     */     
/* 136 */     this.music.play();
/*     */     
/* 138 */     this.fire.setRadius(800);
/* 139 */     this.fire.setFlickerFactor(5.0F);
/* 140 */     this.fire.setZ(100);
/* 141 */     this.fire2.setRadius(800);
/* 142 */     this.fire2.setZ(100);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(float ds, double slowTheFuckDown) {
/* 148 */     this.timer += ds;
/* 149 */     this.fire.flicker(ds);
/*     */     
/* 151 */     if (this.timer > this.ll - quitTime) {
/* 152 */       quit();
/*     */     }
/* 154 */     if (this.quit) {
/* 155 */       this.quitTimer += ds;
/*     */     }
/* 157 */     else if (MButt.LEFT.isDown()) {
/* 158 */       this.quitTimer += ds;
/*     */     } else {
/* 160 */       this.quitTimer -= ds;
/* 161 */       if (this.quitTimer < 0.0D) {
/* 162 */         this.quitTimer = 0.0D;
/*     */       }
/*     */     } 
/* 165 */     if (this.quitTimer >= quitTime) {
/* 166 */       finish();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void keyPush(LIST<KeyBoard.KeyEvent> keys, boolean hasCleared) {
/* 172 */     for (KeyBoard.KeyEvent e : keys) {
/* 173 */       if (e.code() == 256) {
/* 174 */         quit();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds) {
/* 188 */     double blacken = 1.0D;
/* 189 */     if (this.quitTimer > 0.0D) {
/* 190 */       blacken = this.quitTimer / quitTime;
/* 191 */       blacken = CLAMP.d(blacken, 0.0D, 1.0D);
/* 192 */       blacken = 1.0D - blacken;
/* 193 */     } else if (this.timer < 2.0D) {
/* 194 */       blacken = this.timer / 2.0D;
/*     */     } 
/* 196 */     this.music.setGain(blacken);
/* 197 */     AmbientLight.full.register(C.DIM());
/* 198 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 199 */     if (blacken < 1.0D) {
/* 200 */       OpacityImp.TMP.set(1.0D - blacken);
/* 201 */       OpacityImp.TMP.bind();
/* 202 */       COLOR.BLACK.render((SPRITE_RENDERER)r, C.DIM().x1(), C.DIM().x2(), 0, C.DIM().cY() - this.image.height() / 2);
/* 203 */       COLOR.BLACK.render((SPRITE_RENDERER)r, C.DIM().x1(), C.DIM().x2(), C.DIM().cY() + this.image.height() / 2, C.DIM().y2());
/* 204 */       OPACITY.unbind();
/*     */     } 
/*     */ 
/*     */     
/* 208 */     r.newLayer(false, 0);
/*     */ 
/*     */     
/* 211 */     int y1 = C.DIM().cY() - this.image.height() / 2;
/* 212 */     int x1 = C.DIM().cX() + 32;
/* 213 */     this.text.render((SPRITE_RENDERER)r, x1, y1, this.timer / this.ll, blacken);
/*     */ 
/*     */     
/* 216 */     r.newLayer(false, 0);
/* 217 */     this.fire.set((C.DIM().cX() - 350), (C.DIM().cY() + this.image.height() / 2 + 50));
/* 218 */     this.fire.register();
/* 219 */     this.fire2.set((C.DIM().cX() - 400), (C.DIM().cY() - this.image.height() / 2 - 50));
/* 220 */     this.fire2.register();
/*     */ 
/*     */     
/* 223 */     y1 = C.DIM().cY() - this.image.height() / 2;
/* 224 */     x1 = (int)((C.DIM().cX() - 800) - (this.image.width() - 400) * this.timer / this.ll);
/* 225 */     this.image.render((SPRITE_RENDERER)r, x1, y1);
/* 226 */     if (blacken < 1.0D) {
/* 227 */       OpacityImp.TMP.set(1.0D - blacken);
/* 228 */       OpacityImp.TMP.bind();
/* 229 */       COLOR.BLACK.render((SPRITE_RENDERER)r, C.DIM());
/* 230 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void finish() {
/* 239 */     CORE.renderer().clear();
/* 240 */     this.light.register(C.DIM());
/* 241 */     (GCOLOR.T()).H1.bind();
/* 242 */     (UI.FONT()).H1.renderC((SPRITE_RENDERER)CORE.renderer(), C.DIM().cX(), C.DIM().cY(), ¤¤loading);
/* 243 */     COLOR.unbind();
/* 244 */     CORE.swapAndPoll();
/* 245 */     CORE.setCurrentState(this.after);
/*     */   }
/*     */   
/*     */   private void quit() {
/* 249 */     this.quit = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\cutscene\CutScene.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */