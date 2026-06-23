/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleResult;
/*     */ import world.battle.spec.WBattleSide;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ 
/*     */ class Res
/*     */   extends GuiSection {
/*  50 */   private static CharSequence ¤¤Victory = "Victory";
/*  51 */   private static CharSequence ¤¤victoryD = "¤The gods have smiled upon your name. Victory is ours and our foe has been beaten.";
/*  52 */   private static CharSequence ¤¤Retreat = "Retreat";
/*  53 */   private static CharSequence ¤¤RetreatD = "¤Our army has retreated to fight another day.";
/*  54 */   private static CharSequence ¤¤Defeat = "¤Defeat";
/*  55 */   private static CharSequence ¤¤DefeatD = "¤A dark day in the annals. The enemy has snatched victory from us.";
/*  56 */   private static CharSequence ¤¤RetreatDefeat = "¤Our army attempted to retreat, but was destroyed in the process.";
/*  57 */   private static CharSequence ¤¤Capture = "Capture";
/*  58 */   private static CharSequence ¤¤CaptureD = "Ship the selected captives to your capital.";
/*  59 */   private static CharSequence ¤¤Execute = "Execute";
/*  60 */   private static CharSequence ¤¤ExecuteD = "Execute the selected captives.";
/*  61 */   private static CharSequence ¤¤Release = "Release";
/*  62 */   private static CharSequence ¤¤ReleaseD = "Have mercy and release all captives. Surely they will never bear arms against you again?";
/*  63 */   private static CharSequence ¤¤eret = "¤Enemy Retreats";
/*  64 */   private static CharSequence ¤¤eretD = "¤Enemy forces trembled before our might and ran before any engagement. We managed to hunt some down and plunder their baggage train.";
/*     */   public static final int width = 600;
/*     */   private Slaves slaves;
/*     */   
/*     */   static {
/*  69 */     D.ts(Res.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private Spoils spoils;
/*     */   
/*     */   private final CharSequence name;
/*     */   
/*     */   Res(final ACTION close, final WBattleResult result, boolean enemyRetreats) {
/*  78 */     CharSequence desc = null;
/*  79 */     if (result.result == BATTLE_RESULT.VICTORY) {
/*  80 */       if (enemyRetreats) {
/*  81 */         this.name = ¤¤eret;
/*  82 */         desc = ¤¤eretD;
/*     */       } else {
/*  84 */         this.name = ¤¤Victory;
/*  85 */         desc = ¤¤victoryD;
/*     */       } 
/*  87 */     } else if (result.result == BATTLE_RESULT.RETREAT) {
/*  88 */       this.name = ¤¤Retreat;
/*  89 */       desc = (result.player.losses() >= result.player.men()) ? ¤¤RetreatDefeat : ¤¤RetreatD;
/*     */     } else {
/*  91 */       this.name = ¤¤Defeat;
/*  92 */       desc = ¤¤DefeatD;
/*     */     } 
/*     */     
/*  95 */     CharSequence[] descs = (UI.FONT()).M.getRows(desc, 600); byte b; int i;
/*     */     CharSequence[] arrayOfCharSequence1;
/*  97 */     for (i = (arrayOfCharSequence1 = descs).length, b = 0; b < i; ) { CharSequence d = arrayOfCharSequence1[b];
/*  98 */       GText t = new GText((UI.FONT()).M, d);
/*  99 */       t.warnify();
/* 100 */       addRelBody(4, DIR.S, (SPRITE)t);
/*     */       b++; }
/*     */     
/* 103 */     addRelBody(16, DIR.S, result(result.player, result.enemy));
/*     */     
/* 105 */     if (result.result == BATTLE_RESULT.VICTORY) {
/*     */       
/* 107 */       this.spoils = new Spoils(result.lostResources, (DOUBLE)(new DOUBLE.DoubleImp()).setD(1.0D));
/* 108 */       addRelBody(16, DIR.S, (RENDEROBJ)this.spoils);
/* 109 */       this.slaves = new Slaves(result.capturedRaces, (DOUBLE)(new DOUBLE.DoubleImp()).setD(1.0D));
/* 110 */       addRelBody(16, DIR.S, (RENDEROBJ)this.slaves);
/*     */     } 
/*     */ 
/*     */     
/* 114 */     addRelBody(16, DIR.S, (RENDEROBJ)new Battle.Butt((SPRITE)(SPRITES.icons()).m.ok, Dic.¤¤Accept)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 118 */             close.exe();
/* 119 */             if (result.result == BATTLE_RESULT.VICTORY) {
/* 120 */               AD.stats().mercy().incD(FACTIONS.player(), Res.this.slaves.mercy());
/* 121 */               result.accept(Res.this.slaves.accepted(), Res.this.spoils.accepted());
/*     */             } else {
/* 123 */               result.accept(null, null);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 134 */     super.render(r, ds);
/* 135 */     int w = (UI.FONT()).H2.width(this.name);
/* 136 */     (UI.PANEL()).titleBoxes[1].renderCY(r, body().cX() - w / 2, body().y1() - 16, w);
/* 137 */     (GCOLOR.T()).H1.bind();
/* 138 */     (UI.FONT()).H2.renderC(r, body().cX(), body().y1() - 16, this.name);
/* 139 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ result(WBattleSide player, WBattleSide enemy) {
/* 144 */     GuiSection s = new GuiSection();
/* 145 */     s.add(rSide(player));
/* 146 */     s.add(rSide(enemy), 300, 0);
/* 147 */     return (RENDEROBJ)s;
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ rSide(WBattleSide player) {
/* 152 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/* 153 */     for (int i = 0; i < player.units().size(); i++) {
/* 154 */       rows.add(new UnitLoss((WBattleUnit)player.units().get(i)));
/*     */     }
/*     */     
/* 157 */     return (RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 5)).view();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class UnitLoss
/*     */     extends GuiSection
/*     */   {
/* 164 */     private static int width = 250;
/*     */     private final WBattleUnit u;
/*     */     
/*     */     public UnitLoss(final WBattleUnit u) {
/* 168 */       this.u = u;
/*     */       
/* 170 */       addRightC(8, (SPRITE)new SPRITE.Imp(24)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 174 */               u.icon().render(r, X1, X2, Y1, Y2);
/*     */             }
/*     */           });
/*     */       
/* 178 */       addRightC(8, (SPRITE)new SPRITE.Imp(200, 16)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 182 */               double dmen = Math.sqrt(u.men() / (Config.battle()).MEN_PER_ARMY);
/* 183 */               X2 = (int)(X1 + (X2 - X1) * dmen);
/*     */               
/* 185 */               double d = (u.men() - u.losses()) / u.men();
/* 186 */               GMeter.render(r, GMeter.C_ORANGE, d, X1, X2, Y1, Y2);
/*     */             }
/*     */           });
/*     */       
/* 190 */       body().setWidth(width);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 196 */       this.u.hover(text);
/* 197 */       GBox b = (GBox)text;
/* 198 */       b.NL(16);
/* 199 */       b.text(Dic.¤¤Losses);
/* 200 */       b.add((SPRITE)GFORMAT.iofk(b.text(), this.u.losses(), this.u.men()));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Spoils
/*     */     extends GuiSection
/*     */   {
/* 207 */     private int[] accepted = Alloc.ii(RESOURCES.ALL().size());
/*     */     
/*     */     private final int[] available;
/*     */     private final DOUBLE mul;
/*     */     
/*     */     Spoils(final int[] resources, final DOUBLE mul) {
/* 213 */       this.available = resources;
/* 214 */       this.mul = mul;
/* 215 */       int am = 4;
/* 216 */       GRows rows = new GRows(am);
/* 217 */       final GText t = new GText((UI.FONT()).S, 16);
/* 218 */       for (RESOURCE res : RESOURCES.ALL()) {
/* 219 */         if (resources[res.index()] != 0)
/*     */         {
/* 221 */           rows.add((RENDEROBJ)new HOVERABLE.HoverableAbs(600 / am - 12, 28)
/*     */               {
/*     */                 protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */                 {
/* 225 */                   (res.icon()).medium.renderCY(r, body().x1() + 8, body().cY());
/* 226 */                   t.clear();
/* 227 */                   GFORMAT.iIncr(t, (long)(resources[res.index()] * mul.getD()));
/* 228 */                   t.renderCY(r, body().x1() + 40, body().cY());
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GUI_BOX text) {
/* 233 */                   text.title(res.names);
/*     */                 }
/*     */               });
/*     */         }
/*     */       } 
/*     */       
/* 239 */       add((RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 112)).view());
/*     */     }
/*     */     
/*     */     public int[] accepted() {
/* 243 */       for (int i = 0; i < this.accepted.length; i++) {
/* 244 */         this.accepted[i] = CLAMP.i((int)(this.available[i] * this.mul.getD()), 0, this.available[i]);
/*     */       }
/* 246 */       return this.accepted;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Slaves
/*     */     extends GuiSection {
/* 252 */     private int[] accepted = Alloc.ii(RACES.all().size());
/*     */     
/*     */     private final DOUBLE mul;
/*     */     
/*     */     private final int[] available;
/*     */     private boolean enslave = true;
/*     */     private boolean release = false;
/*     */     
/*     */     public Slaves(final int[] available, final DOUBLE mul) {
/* 261 */       add((RENDEROBJ)new GHeader((HTYPES.PRISONER()).names));
/*     */       
/* 263 */       this.mul = mul;
/* 264 */       this.available = available;
/*     */ 
/*     */       
/* 267 */       int am = 2;
/* 268 */       GRows rows = new GRows(am);
/*     */       
/* 270 */       for (Race race : RACES.all()) {
/*     */         
/* 272 */         if (available[race.index] == 0) {
/*     */           continue;
/*     */         }
/* 275 */         this.accepted[race.index] = available[race.index];
/*     */         
/* 277 */         INT.INTE in = new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 281 */               return 0;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public int max() {
/* 287 */               return (int)(available[race.index] * mul.getD());
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 292 */               if (Res.Slaves.this.release)
/* 293 */                 return 0; 
/* 294 */               return CLAMP.i(Res.Slaves.this.accepted[race.index], 0, max());
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 299 */               Res.Slaves.this.accepted[race.index] = t;
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 304 */         GSliderInt t = new GSliderInt(in, 176, this.active)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 307 */               text.title(race.info.names);
/* 308 */               super.hoverInfoGet(text);
/* 309 */               text.NL();
/* 310 */               text.text(Dic.¤¤CaptivesD);
/*     */             }
/*     */           };
/*     */         
/* 314 */         t.addRelBody(4, DIR.W, (race.appearance()).icon.medium);
/* 315 */         t.body().incrW(24.0D);
/* 316 */         t.pad(0, 2);
/* 317 */         rows.add((RENDEROBJ)t);
/*     */       } 
/*     */       
/* 320 */       addRelBody(4, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 112)).view());
/*     */       
/* 322 */       GuiSection s = new GuiSection();
/*     */       
/* 324 */       s.add((RENDEROBJ)(new GButt.ButtPanel(Res.¤¤Capture, 180)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 328 */               Res.Slaves.this.enslave = true;
/* 329 */               Res.Slaves.this.release = false;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 334 */               selectedSet((Res.Slaves.this.enslave && !Res.Slaves.this.release));
/*     */             }
/* 337 */           }).hoverInfoSet(Res.¤¤CaptureD));
/* 338 */       s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Res.¤¤Execute, 180)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 342 */               Res.Slaves.this.enslave = false;
/* 343 */               Res.Slaves.this.release = false;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 348 */               selectedSet((!Res.Slaves.this.enslave && !Res.Slaves.this.release));
/*     */             }
/* 351 */           }).hoverInfoSet(Res.¤¤ExecuteD));
/*     */       
/* 353 */       s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Res.¤¤Release, 180)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 357 */               Res.Slaves.this.release = true;
/* 358 */               Res.Slaves.this.enslave = false;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 363 */               selectedSet(Res.Slaves.this.release);
/*     */             }
/* 366 */           }).hoverInfoSet(Res.¤¤ReleaseD));
/*     */       
/* 368 */       addRelBody(4, DIR.S, (RENDEROBJ)s);
/*     */       
/* 370 */       addRelBody(4, DIR.S, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 374 */               GFORMAT.percInc(text, Res.Slaves.this.mercy());
/*     */             }
/* 376 */           }).hv((ROPINION.STANCE()).chivalry.info.name));
/*     */       
/* 378 */       pad(8);
/*     */     }
/*     */ 
/*     */     
/*     */     public int[] accepted() {
/* 383 */       if (!this.enslave || this.release) {
/* 384 */         for (int i = 0; i < this.accepted.length; i++) {
/* 385 */           this.accepted[i] = 0;
/*     */         }
/*     */       } else {
/* 388 */         for (int i = 0; i < this.accepted.length; i++) {
/* 389 */           this.accepted[i] = CLAMP.i(this.accepted[i], 0, (int)(this.available[i] * this.mul.getD()));
/*     */         }
/*     */       } 
/*     */       
/* 393 */       return this.accepted;
/*     */     }
/*     */     
/*     */     public int mercyAmount() {
/* 397 */       int tot = 0;
/* 398 */       int sel = 0;
/* 399 */       for (int i = 0; i < this.accepted.length; i++) {
/* 400 */         int t = (int)(this.available[i] * this.mul.getD());
/* 401 */         tot += t;
/* 402 */         sel += this.release ? t : CLAMP.i(this.accepted[i], 0, t);
/*     */       } 
/* 404 */       if (tot == 0) {
/* 405 */         return 0;
/*     */       }
/*     */       
/* 408 */       if (this.release) {
/* 409 */         sel = tot;
/* 410 */       } else if (this.enslave) {
/* 411 */         sel = -sel / 2;
/*     */       } else {
/* 413 */         sel = -sel;
/*     */       } 
/* 415 */       return sel;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double mercy() {
/* 424 */       double m = mercyAmount();
/* 425 */       m /= (1 + POP.tot(null));
/* 426 */       return m;
/*     */     }
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
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 455 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/* 456 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Res.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */