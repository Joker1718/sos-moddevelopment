/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ class Slaves
/*     */   extends GuiSection
/*     */ {
/* 252 */   private int[] accepted = Alloc.ii(RACES.all().size());
/*     */   
/*     */   private final DOUBLE mul;
/*     */   
/*     */   private final int[] available;
/*     */   private boolean enslave = true;
/*     */   private boolean release = false;
/*     */   
/*     */   public Slaves(final int[] available, final DOUBLE mul) {
/* 261 */     add((RENDEROBJ)new GHeader((HTYPES.PRISONER()).names));
/*     */     
/* 263 */     this.mul = mul;
/* 264 */     this.available = available;
/*     */ 
/*     */     
/* 267 */     int am = 2;
/* 268 */     GRows rows = new GRows(am);
/*     */     
/* 270 */     for (Race race : RACES.all()) {
/*     */       
/* 272 */       if (available[race.index] == 0) {
/*     */         continue;
/*     */       }
/* 275 */       this.accepted[race.index] = available[race.index];
/*     */       
/* 277 */       INT.INTE in = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 281 */             return 0;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public int max() {
/* 287 */             return (int)(available[race.index] * mul.getD());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 292 */             if (Res.Slaves.this.release)
/* 293 */               return 0; 
/* 294 */             return CLAMP.i(Res.Slaves.this.accepted[race.index], 0, max());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 299 */             Res.Slaves.this.accepted[race.index] = t;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 304 */       GSliderInt t = new GSliderInt(in, 176, this.active)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 307 */             text.title(race.info.names);
/* 308 */             super.hoverInfoGet(text);
/* 309 */             text.NL();
/* 310 */             text.text(Dic.¤¤CaptivesD);
/*     */           }
/*     */         };
/*     */       
/* 314 */       t.addRelBody(4, DIR.W, (race.appearance()).icon.medium);
/* 315 */       t.body().incrW(24.0D);
/* 316 */       t.pad(0, 2);
/* 317 */       rows.add((RENDEROBJ)t);
/*     */     } 
/*     */     
/* 320 */     addRelBody(4, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 112)).view());
/*     */     
/* 322 */     GuiSection s = new GuiSection();
/*     */     
/* 324 */     s.add((RENDEROBJ)(new GButt.ButtPanel(Res.¤¤Capture, 180)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 328 */             Res.Slaves.this.enslave = true;
/* 329 */             Res.Slaves.this.release = false;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 334 */             selectedSet((Res.Slaves.this.enslave && !Res.Slaves.this.release));
/*     */           }
/* 337 */         }).hoverInfoSet(Res.¤¤CaptureD));
/* 338 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Res.¤¤Execute, 180)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 342 */             Res.Slaves.this.enslave = false;
/* 343 */             Res.Slaves.this.release = false;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 348 */             selectedSet((!Res.Slaves.this.enslave && !Res.Slaves.this.release));
/*     */           }
/* 351 */         }).hoverInfoSet(Res.¤¤ExecuteD));
/*     */     
/* 353 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Res.¤¤Release, 180)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 357 */             Res.Slaves.this.release = true;
/* 358 */             Res.Slaves.this.enslave = false;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 363 */             selectedSet(Res.Slaves.this.release);
/*     */           }
/* 366 */         }).hoverInfoSet(Res.¤¤ReleaseD));
/*     */     
/* 368 */     addRelBody(4, DIR.S, (RENDEROBJ)s);
/*     */     
/* 370 */     addRelBody(4, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 374 */             GFORMAT.percInc(text, Res.Slaves.this.mercy());
/*     */           }
/* 376 */         }).hv((ROPINION.STANCE()).chivalry.info.name));
/*     */     
/* 378 */     pad(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] accepted() {
/* 383 */     if (!this.enslave || this.release) {
/* 384 */       for (int i = 0; i < this.accepted.length; i++) {
/* 385 */         this.accepted[i] = 0;
/*     */       }
/*     */     } else {
/* 388 */       for (int i = 0; i < this.accepted.length; i++) {
/* 389 */         this.accepted[i] = CLAMP.i(this.accepted[i], 0, (int)(this.available[i] * this.mul.getD()));
/*     */       }
/*     */     } 
/*     */     
/* 393 */     return this.accepted;
/*     */   }
/*     */   
/*     */   public int mercyAmount() {
/* 397 */     int tot = 0;
/* 398 */     int sel = 0;
/* 399 */     for (int i = 0; i < this.accepted.length; i++) {
/* 400 */       int t = (int)(this.available[i] * this.mul.getD());
/* 401 */       tot += t;
/* 402 */       sel += this.release ? t : CLAMP.i(this.accepted[i], 0, t);
/*     */     } 
/* 404 */     if (tot == 0) {
/* 405 */       return 0;
/*     */     }
/*     */     
/* 408 */     if (this.release) {
/* 409 */       sel = tot;
/* 410 */     } else if (this.enslave) {
/* 411 */       sel = -sel / 2;
/*     */     } else {
/* 413 */       sel = -sel;
/*     */     } 
/* 415 */     return sel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double mercy() {
/* 424 */     double m = mercyAmount();
/* 425 */     m /= (1 + POP.tot(null));
/* 426 */     return m;
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
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 455 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/* 456 */     super.render(r, ds);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Res$Slaves.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */