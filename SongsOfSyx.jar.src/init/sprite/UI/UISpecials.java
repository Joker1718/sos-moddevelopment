/*     */ package init.sprite.UI;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.DicTime;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.Key;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UISpecials
/*     */ {
/*  42 */   private final TILE_SHEET clockwork = (new ComposerThings.ITileSheet(PATHS.SPRITE_UI().get("Specials"), 1320, 208)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  46 */         s.full.init(0, 0, 1, 1, 3, 1, d.s32);
/*  47 */         s.full.paste(true);
/*  48 */         return d.s32.saveGui();
/*     */       }
/*  50 */     }).get();
/*     */   
/*  52 */   private final SPRITE background = (SPRITE)new ComposerThings.ITileSprite(192, 64, 1)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  56 */         s.full.init(s.full.body().x2(), 0, 1, 1, 6, 2, d.s32);
/*  57 */         s.full.paste(true);
/*  58 */         return d.s32.saveGui();
/*     */       }
/*     */     };
/*     */   
/*  62 */   private final TILE_SHEET selest = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  66 */         s.full.init(0, s.full.body().y2(), 1, 1, 16, 1, d.s16);
/*  67 */         s.full.setVar(0).setSkip(2, 0);
/*  68 */         s.full.paste(true);
/*  69 */         return d.s16.saveGui();
/*     */       }
/*  71 */     }).get();
/*     */ 
/*     */   
/*  74 */   private final TILE_SHEET buttons = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  78 */         s.full.setSkip(10, 2);
/*  79 */         s.full.paste(true);
/*  80 */         return d.s16.saveGui();
/*     */       }
/*  82 */     }).get();
/*     */   
/*  84 */   private final TILE_SHEET upperPanel = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  88 */         s.full.init(0, s.full.body().y2(), 1, 1, 27, 2, d.s24);
/*  89 */         s.full.pasteRotated(2, true);
/*  90 */         return d.s24.saveGui();
/*     */       }
/*  92 */     }).get();
/*     */   
/*  94 */   private final TILE_SHEET seasons = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  98 */         s.full.init(0, s.full.body().y2(), 1, 1, 8, 1, d.s32);
/*  99 */         s.full.paste(true);
/* 100 */         return d.s32.saveGui();
/*     */       }
/* 102 */     }).get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE lowerPanel() {
/* 112 */     return new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 116 */           return UISpecials.this.upperPanel.size() * 27;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 121 */           return UISpecials.this.upperPanel.size() * 2;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 132 */           int startTile = 0;
/* 133 */           int endTile = 27;
/* 134 */           for (int y = 0; y < 2; y++) {
/* 135 */             for (int x = startTile; x < endTile; x++) {
/* 136 */               UISpecials.this.upperPanel.render(r, 26 - x + (1 - y) * 27, X1 + (x - startTile) * UISpecials.this.upperPanel.size(), Y1 + y * UISpecials.this.upperPanel.size());
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiSection buildTimeThing(boolean simplified) {
/* 146 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 149 */           GAME.SPEED.poll();
/* 150 */           super.render(r, ds);
/*     */         }
/*     */       };
/* 153 */     if (!simplified) {
/* 154 */       s.add(this.background, 0, 0);
/*     */     }
/*     */ 
/*     */     
/* 158 */     GAME.SPEED.getClass(); CLICKABLE c = speedButt((KEYS.MAIN()).PAUSE, 0, 0);
/* 159 */     s.add((RENDEROBJ)c, 32, 4);
/* 160 */     GAME.SPEED.getClass(); c = speedButt((KEYS.MAIN()).SPEED1, 1, 1);
/* 161 */     s.addRightC(0, (RENDEROBJ)c);
/* 162 */     GAME.SPEED.getClass(); c = speedButt((KEYS.MAIN()).SPEED2, 2, 5);
/* 163 */     s.addRightC(0, (RENDEROBJ)c);
/* 164 */     GAME.SPEED.getClass(); c = speedButt((KEYS.MAIN()).SPEED3, 3, 25);
/* 165 */     s.addRightC(0, (RENDEROBJ)c);
/*     */ 
/*     */ 
/*     */     
/* 169 */     if (!simplified) {
/* 170 */       s.add((RENDEROBJ)new ClockWork(), 48, 29);
/* 171 */       s.moveLastToBack();
/*     */     } 
/*     */     
/* 174 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private CLICKABLE speedButt(Key key, final int i, final int speed) {
/* 179 */     CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(2 * this.buttons.size(), this.buttons.size())
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, int isSelected, boolean isHovered)
/*     */         {
/* 183 */           isSelected = (GAME.SPEED.speedTarget() == speed) ? 1 : 0;
/*     */           
/* 185 */           GAME.SPEED.getClass(); GAME.SPEED.getClass(); boolean sspeed = (speed == 25 && GAME.SPEED.speedTarget() == 250.0D);
/* 186 */           GAME.SPEED.getClass(); GAME.SPEED.getClass(); int j = sspeed | ((speed == 1 && GAME.SPEED.speedTarget() == 0.25D) ? 1 : 0);
/* 187 */           int i = isSelected | j;
/*     */           
/* 189 */           if (isHovered || i != 0) {
/* 190 */             OPACITY.O99.bind();
/* 191 */             UISpecials.this.buttons.render(r, 8, body().x1(), body().y1());
/* 192 */             UISpecials.this.buttons.render(r, 9, body().x1() + UISpecials.this.buttons.size(), body().y1());
/* 193 */             OPACITY.unbind();
/*     */           } 
/*     */           
/* 196 */           if (!isActive) {
/* 197 */             (GCOLOR.T()).INACTIVE.bind();
/* 198 */           } else if (i != 0 && isHovered) {
/* 199 */             (GCOLOR.T()).HOVER_SELECTED.bind();
/* 200 */           } else if (i != 0) {
/* 201 */             (GCOLOR.T()).SELECTED.bind();
/* 202 */           } else if (isHovered) {
/* 203 */             (GCOLOR.T()).HOVERED.bind();
/*     */           } else {
/* 205 */             COLOR.WHITE100.bind();
/* 206 */           }  UISpecials.this.buttons.render(r, i * 2, body().x1(), body().y1());
/* 207 */           UISpecials.this.buttons.render(r, i * 2 + 1, body().x1() + UISpecials.this.buttons.size(), body().y1());
/* 208 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 214 */           GAME.SPEED.getClass(); if (speed == 0)
/* 215 */             GAME.SPEED.togglePause(); 
/* 216 */           GAME.SPEED.getClass(); GAME.SPEED.getClass(); if (speed == 1 && GAME.SPEED.speedTarget() == 1.0D) {
/* 217 */             GAME.SPEED.getClass(); GAME.SPEED.speedSet(0.25D);
/* 218 */           }  GAME.SPEED.getClass(); GAME.SPEED.getClass(); if (speed == 25 && GAME.SPEED.speedTarget() == 25.0D) {
/* 219 */             GAME.SPEED.getClass(); GAME.SPEED.speedSet(250.0D);
/*     */           } else {
/* 221 */             GAME.SPEED.speedSet(speed);
/*     */           } 
/*     */         }
/*     */       };
/* 225 */     return KeyButt.wrap((CLICKABLE)clickableAbs, key);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class ClockWork
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/* 233 */     private final TextureCoords text = new TextureCoords();
/* 234 */     private final GuiSection hover = new GuiSection();
/*     */     
/*     */     public ClockWork() {
/* 237 */       body().setWidth((UISpecials.this.clockwork.size() * UISpecials.this.clockwork.tiles())).setHeight(UISpecials.this.clockwork.size());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 243 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 247 */             DicTime.setTime((Str)text, TIME.currentSecond());
/* 248 */             text.lablify();
/*     */           }
/* 250 */         }).r(DIR.N);
/* 251 */       this.hover.addDownC(2, (RENDEROBJ)hOVERABLE);
/*     */ 
/*     */       
/* 254 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 258 */             DicTime.setDate((Str)text, (int)TIME.currentSecond());
/* 259 */             text.lablifySub();
/*     */           }
/* 261 */         }).r(DIR.N);
/* 262 */       this.hover.addDownC(2, (RENDEROBJ)hOVERABLE);
/*     */       
/* 264 */       this.hover.pad(200, 10);
/*     */       
/* 266 */       GuiSection ss = new GuiSection()
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 270 */             if (!VIEW.s().isActive() && !VIEW.b().isActive()) {
/*     */               return;
/*     */             }
/* 273 */             super.render(r, ds);
/*     */           }
/*     */         };
/*     */       
/* 277 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 281 */             (SETT.WEATHER()).temp.format((Str)text);
/* 282 */             if ((SETT.WEATHER()).temp.cold() > 0.0D) {
/* 283 */               GFORMAT.colorInter(text, (SETT.WEATHER()).temp.cold(), 1.0D);
/*     */             } else {
/* 285 */               GFORMAT.colorInterInv(text, (SETT.WEATHER()).temp.heat(), 1.0D);
/*     */             }  }
/* 287 */         }).hv((SETT.WEATHER()).temp.info.name);
/* 288 */       ss.addC((RENDEROBJ)hOVERABLE, -100, 0);
/*     */       
/* 290 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 294 */             GFORMAT.perc(text, (SETT.WEATHER()).moisture.getD());
/*     */           }
/* 296 */         }).hv((SETT.WEATHER()).moisture.info.name);
/* 297 */       ss.addC((RENDEROBJ)hOVERABLE, 100, 0);
/*     */       
/* 299 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 303 */             GFORMAT.perc(text, (SETT.WEATHER()).wind.getD());
/*     */           }
/* 305 */         }).hv((SETT.WEATHER()).wind.info.name);
/* 306 */       ss.addC((RENDEROBJ)hOVERABLE, -100, 50);
/*     */       
/* 308 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 312 */             GFORMAT.perc(text, (SETT.WEATHER()).growth.getD());
/*     */           }
/* 314 */         }).hv((SETT.WEATHER()).growth.info.name);
/* 315 */       ss.addC((RENDEROBJ)hOVERABLE, 100, 50);
/*     */       
/* 317 */       this.hover.addRelBody(8, DIR.S, (RENDEROBJ)ss);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 324 */       if (isHovered)
/* 325 */         COLOR.WHITE150.bind(); 
/* 326 */       int off = (int)(TIME.currentSecond() * 2.0D) % UISpecials.this.clockwork.size();
/* 327 */       int width = UISpecials.this.clockwork.size() - off;
/* 328 */       int x1 = body().x1();
/* 329 */       if (off != 0) {
/* 330 */         TextureCoords c = UISpecials.this.clockwork.getTexture(0);
/* 331 */         this.text.get(c.x1 + off, c.y1, width, c.y2 - c.y1);
/* 332 */         CORE.renderer().renderSprite(body().x1(), body().x1() + width, body().y1() - 0, body().y2() - 0, this.text);
/* 333 */         x1 += width;
/*     */       } else {
/* 335 */         UISpecials.this.clockwork.render(r, 0, body().x1(), body().y1() - 0);
/* 336 */         x1 += UISpecials.this.clockwork.size();
/*     */       } 
/* 338 */       for (int i = 1; i < UISpecials.this.clockwork.tiles(); i++) {
/* 339 */         UISpecials.this.clockwork.render(r, i, x1 + (i - 1) * UISpecials.this.clockwork.size(), body().y1() - 0);
/*     */       }
/* 341 */       if (off != 0) {
/* 342 */         TextureCoords c = UISpecials.this.clockwork.getTexture(0);
/* 343 */         this.text.get(c.x1, c.y1, off, c.y2 - c.y1);
/* 344 */         CORE.renderer().renderSprite(body().x2() - off, body().x2(), body().y1() - 0, body().y2() - 0, this.text);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 350 */       renderSeasons();
/* 351 */       COLOR.unbind();
/*     */ 
/*     */       
/* 354 */       int sI = TIME.light().nightIs() ? 1 : 0;
/* 355 */       int w = body().width() + UISpecials.this.selest.size() - 8;
/* 356 */       x1 = (int)((body().x1() + 4 - UISpecials.this.selest.size()) + TIME.light().partOf() * w);
/*     */       
/* 358 */       if (!render(UISpecials.this.selest.size(), UISpecials.this.selest.getTexture(sI), x1, body().y1() + 8)) {
/* 359 */         UISpecials.this.selest.render(r, sI, x1, body().y1() + 8);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private void renderSeasons() {
/* 365 */       int pw = UISpecials.this.seasons.size();
/* 366 */       int width = UISpecials.this.seasons.tiles() * pw;
/*     */       
/* 368 */       int x1 = body().x1();
/* 369 */       int x2 = body().x2();
/*     */       
/* 371 */       int start = x1 - (int)(TIME.years().bitPartOf() * width) - pw / 2;
/*     */ 
/*     */       
/* 374 */       int t = 6;
/* 375 */       while (start < x2) {
/*     */         
/* 377 */         TextureCoords coo = UISpecials.this.seasons.getTexture(t);
/*     */         
/* 379 */         int offX1 = 0;
/* 380 */         int offX2 = 0;
/*     */ 
/*     */         
/* 383 */         if (start < x1) {
/* 384 */           offX1 = x1 - start;
/*     */         }
/*     */ 
/*     */         
/* 388 */         if (start + pw > x2) {
/* 389 */           offX2 = start + pw - x2;
/*     */         }
/*     */         
/* 392 */         if (offX1 < pw && offX2 < pw) {
/* 393 */           this.text.get(coo.x1 + offX1, coo.y1, pw - offX2 + offX1, coo.y2 - coo.y1);
/* 394 */           CORE.renderer().renderSprite(start + offX1, start + pw - offX2, body().y1(), body().y1() + this.text.height(), this.text);
/*     */         } 
/*     */ 
/*     */         
/* 398 */         start += pw;
/* 399 */         t++;
/* 400 */         t %= UISpecials.this.seasons.tiles();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean render(int size, TextureCoords c, int x1, int y1) {
/* 407 */       if (x1 + size <= body().x1())
/* 408 */         return true; 
/* 409 */       if (x1 >= body().x2())
/* 410 */         return true; 
/* 411 */       if (x1 < body().x1()) {
/*     */         
/* 413 */         int off = body().x1() - x1;
/* 414 */         this.text.get(c.x1 + off, c.y1, size - off, c.y2 - c.y1);
/* 415 */         CORE.renderer().renderSprite(body().x1(), body().x1() + size - off, y1, y1 + size, this.text);
/* 416 */         return true;
/* 417 */       }  if (x1 + size > body().x2()) {
/* 418 */         int width = body().x2() - x1;
/* 419 */         this.text.get(c.x1, c.y1, width, c.y2 - c.y1);
/* 420 */         CORE.renderer().renderSprite(x1, x1 + width, y1, y1 + size, this.text);
/* 421 */         return true;
/*     */       } 
/* 423 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 428 */       GBox b = (GBox)text;
/* 429 */       b.add((RENDEROBJ)this.hover);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UISpecials.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */