/*     */ package menu;
/*     */ 
/*     */ import game.faction.player.PTitles;
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.KeyBoard;
/*     */ import snake2d.MButt;
/*     */ import snake2d.PreLoader;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.PointLight;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class Menu
/*     */   extends CORE_STATE
/*     */ {
/*     */   final ScMain main;
/*     */   final ScOptions options;
/*     */   final ScLoad load;
/*     */   final ScLoad[] loads;
/*     */   final ScRandom sandbox2;
/*     */   final ScRandomSettings sandboxSettings;
/*     */   final ScCredits credits;
/*     */   final ScCampaign campaigns;
/*     */   private SC current;
/*  37 */   private Coo mCoo = new Coo();
/*     */   
/*     */   private final Background bg;
/*     */   
/*     */   private final PointLight mouseLight;
/*     */   
/*     */   private final Logo logo;
/*     */   
/*     */   private static boolean hasLogo = true;
/*     */   private final Intro intro;
/*     */   private static boolean hasIntro = true;
/*  48 */   private float fadeLight = 0.0F;
/*     */   
/*     */   public final RESOURCES res;
/*     */   
/*     */   private final SPRITE_RENDERER rr;
/*     */   
/*     */   public static void start() {
/*  55 */     CORE.create(S.get().make());
/*  56 */     CORE.getInput().getMouse().showCusor(false);
/*  57 */     CORE.start(new CORE_STATE.Constructor()
/*     */         {
/*     */           public CORE_STATE getState() {
/*  60 */             return Menu.make();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Menu make() {
/*  68 */     Menu menu = new Menu();
/*  69 */     PreLoader.exit();
/*  70 */     return menu;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Menu makeCampaign() {
/*  75 */     Menu menu = new Menu();
/*  76 */     PreLoader.exit();
/*  77 */     menu.switchScreen(menu.campaigns);
/*  78 */     return menu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 116 */     this.mCoo.set(mCoo);
/* 117 */     if (hasIntro || hasLogo) {
/*     */       return;
/*     */     }
/* 120 */     this.mouseLight.set(mCoo);
/* 121 */     this.current.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float ds, double slow) {
/* 126 */     hover((COORDINATE)CORE.getInput().getMouse().getCoo(), false);
/* 127 */     if (hasLogo) {
/* 128 */       hasLogo = this.logo.update(ds);
/*     */       
/*     */       return;
/*     */     } 
/* 132 */     this.res.sound().play();
/*     */     
/* 134 */     hasIntro = (hasIntro && this.intro.update(ds));
/* 135 */     if (!hasIntro && this.fadeLight < 1.0F) {
/* 136 */       this.fadeLight += ds;
/* 137 */       if (this.fadeLight > 1.0F) {
/* 138 */         this.fadeLight = 1.0F;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Renderer r, float ds) {
/* 144 */     CORE.renderer().shadeLight(true);
/* 145 */     CORE.renderer().shadowDepthDefault();
/* 146 */     if (hasLogo) {
/* 147 */       this.logo.render(r, ds);
/*     */       
/*     */       return;
/*     */     } 
/* 151 */     if (hasIntro) {
/* 152 */       this.intro.render(r, ds);
/*     */       
/*     */       return;
/*     */     } 
/* 156 */     AmbientLight.Strongmoonlight.register(C.DIM());
/* 157 */     (UI.decor()).mouse.render((SPRITE_RENDERER)r, this.mCoo.x(), this.mCoo.y());
/* 158 */     r.newLayer(true, 0);
/*     */     
/* 160 */     this.mouseLight.setRed(this.fadeLight);
/* 161 */     this.mouseLight.setGreen(this.fadeLight);
/* 162 */     this.mouseLight.setBlue(this.fadeLight * 1.3D);
/*     */     
/* 164 */     this.mouseLight.register();
/* 165 */     this.current.render(this.rr, ds);
/*     */     
/* 167 */     r.newLayer(false, 0);
/*     */     
/* 169 */     this.current.renderBackground(this.bg, ds, (COORDINATE)this.mCoo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClick(MButt button) {
/* 176 */     if (hasLogo) {
/* 177 */       hasLogo = false;
/*     */       
/*     */       return;
/*     */     } 
/* 181 */     if (hasIntro) {
/* 182 */       hasIntro = false;
/*     */       
/*     */       return;
/*     */     } 
/* 186 */     if (button == MButt.LEFT) {
/* 187 */       this.current.click();
/*     */     }
/* 189 */     if (button == MButt.RIGHT) {
/* 190 */       this.current.back(this);
/*     */     }
/*     */   }
/*     */   
/*     */   void switchScreen(SC screen) {
/* 195 */     this.current = screen;
/* 196 */     this.current.hover((COORDINATE)this.mCoo);
/*     */   }
/*     */   
/*     */   SC screen() {
/* 200 */     return this.current;
/*     */   }
/*     */   
/*     */   Coo getMCoo() {
/* 204 */     return this.mCoo;
/*     */   }
/*     */   
/*     */   void start(CORE_STATE.Constructor state) {
/* 208 */     CORE.renderer().clear();
/*     */     
/* 210 */     GuiSection s = new GuiSection();
/* 211 */     GUI.addTitleText(s, Dic.¤¤loading);
/* 212 */     s.body().centerIn(C.DIM());
/* 213 */     s.render(this.rr, 0.0F);
/* 214 */     AmbientLight.Strongmoonlight.register(C.DIM());
/* 215 */     CORE.renderer().newLayer(false, 0);
/* 216 */     this.bg.render((SPRITE_RENDERER)CORE.renderer(), 0.0F);
/*     */     
/* 218 */     CORE.swapAndPoll();
/* 219 */     CORE.setCurrentState(state);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void keyPush(LIST<KeyBoard.KeyEvent> keys, boolean hasCleared) {
/* 224 */     for (int i = 0; i < keys.size(); i++) {
/* 225 */       KeyBoard.KeyEvent key = (KeyBoard.KeyEvent)keys.get(i);
/* 226 */       if (hasLogo) {
/* 227 */         hasLogo = false;
/*     */         
/*     */         return;
/*     */       } 
/* 231 */       if (hasIntro) {
/* 232 */         hasIntro = false;
/*     */         return;
/*     */       } 
/* 235 */       if (key.code() == 256) {
/* 236 */         if (!this.current.back(this)) {
/*     */           return;
/*     */         }
/*     */         break;
/*     */       } 
/* 241 */       this.current.poll(key);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Menu() {
/* 248 */     this.rr = new SPRITE_RENDERER()
/*     */       {
/* 250 */         private final int ss = 4;
/* 251 */         private final int si = 8;
/*     */ 
/*     */         
/*     */         public void renderSprite(int x1, int x2, int y1, int y2, TextureCoords texture) {
/* 255 */           CORE.renderer().renderSprite(x1, x2, y1, y2, texture);
/* 256 */           for (int i = 0; i < 8; i++)
/* 257 */             CORE.renderer().renderShadow(x1 + 4 + i, x2 + 4 + i, y1 - 4 - i, y2 - 4 - i, texture, (byte)0); 
/*     */         }
/*     */       };
/*     */     this.res = new RESOURCES();
/*     */     Rec bounds = new Rec(0.0D, 1280.0D, 0.0D, 512.0D);
/*     */     bounds.centerIn(C.DIM());
/*     */     GUI.init((RECTANGLE)bounds);
/*     */     this.bg = new Background(this, (RECTANGLE)bounds);
/*     */     this.options = new ScOptions(this);
/*     */     this.sandbox2 = new ScRandom(this);
/*     */     this.sandboxSettings = new ScRandomSettings(this);
/*     */     this.load = ScLoad.load(this);
/*     */     this.loads = new ScLoad[] { ScLoad.scenarios(this), ScLoad.battle(this), ScLoad.showcase(this) };
/*     */     this.credits = new ScCredits(this);
/*     */     this.main = new ScMain(this);
/*     */     this.campaigns = new ScCampaign(this);
/*     */     this.current = this.main;
/*     */     this.mouseLight = new PointLight(1.0D, 1.0D, 1.2999999523162842D, 0, 0, 15);
/*     */     this.mouseLight.setFalloff(1.0F);
/*     */     this.intro = new Intro(this.main, this.bg);
/*     */     this.logo = new Logo(this);
/*     */     S.get().applyRuntimeConfigs();
/*     */     PTitles.achieve();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\Menu.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */