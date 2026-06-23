/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.thing.projectiles.SProjectiles;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ final class BattlePlacerAttack
/*     */   extends BattlePlacer.Mode
/*     */ {
/*  39 */   private static CharSequence ¤¤AttackMelee = "¤Attack unit";
/*  40 */   private static CharSequence ¤¤AttackRanged = "¤Fire at unit";
/*  41 */   private static CharSequence ¤¤AttackRangedDesc = "¤(Hold {0} to attack melee)";
/*  42 */   private static CharSequence ¤¤AttackMix = "¤Attack/fire at unit";
/*     */   
/*  44 */   private static CharSequence ¤¤AttackBuilding = "¤Attack Building";
/*  45 */   private static CharSequence ¤¤BombardBuilding = "¤Bombard Building";
/*  46 */   private static CharSequence ¤¤BombardArea = "¤Bombard Area";
/*     */   
/*     */   private boolean melees;
/*     */   private boolean archers;
/*     */   private boolean artillery;
/*  51 */   private final Trajectory traj = new Trajectory();
/*     */   
/*     */   static {
/*  54 */     D.ts(BattlePlacerAttack.class);
/*     */   }
/*     */   
/*     */   private final GameWindow w;
/*     */   private final DivSelection s;
/*     */   private final BattlePlacer.Action a;
/*  60 */   private final BattleOrderTask task = new BattleOrderTask();
/*     */   
/*     */   private Target tar;
/*     */   
/*     */   private final Target div;
/*     */   private final Target room;
/*     */   private final Target building;
/*     */   private final Target ground;
/*     */   
/*     */   private Target get() {
/*  70 */     if (this.div.set())
/*  71 */       return this.div; 
/*  72 */     if (this.room.set())
/*  73 */       return this.room; 
/*  74 */     if (this.building.set())
/*  75 */       return this.building; 
/*  76 */     if (this.ground.set())
/*  77 */       return this.ground; 
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean init() {
/*  83 */     this.melees = false;
/*  84 */     this.archers = false;
/*  85 */     this.artillery = false;
/*  86 */     for (Div dd : this.s.selection()) {
/*     */ 
/*     */       
/*  89 */       if (dd.menNrOf() > 0) {
/*  90 */         if (dd.settings().ammo() != null && !(KEYS.MAIN()).UNDO.isPressed()) {
/*  91 */           this.archers |= 0x1; continue;
/*     */         } 
/*  93 */         this.melees |= 0x1;
/*     */       } 
/*     */     } 
/*  96 */     this.artillery = (!(KEYS.MAIN()).UNDO.isPressed() && !this.s.artillery.isClear());
/*     */     
/*  98 */     if (!this.melees && !this.archers && !this.artillery) {
/*  99 */       return false;
/*     */     }
/* 101 */     this.tar = get();
/*     */     
/* 103 */     return (this.tar != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(boolean hovered) {
/* 111 */     if (!hovered) {
/*     */       return;
/*     */     }
/* 114 */     if (!this.a.clickReleased) {
/*     */       return;
/*     */     }
/* 117 */     get().click();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 124 */     this.tar.render(r, shadowBatch, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void hoverTimer(GBox text) {
/* 131 */     text.text(this.tar.name());
/* 132 */     text.NL();
/* 133 */     this.tar.problem(text);
/*     */   }
/*     */ 
/*     */   
/*     */   private abstract class Target
/*     */   {
/*     */     abstract boolean set();
/*     */ 
/*     */     
/*     */     abstract CharSequence name();
/*     */ 
/*     */     
/*     */     abstract void problem(GBox param1GBox);
/*     */ 
/*     */     
/*     */     abstract void click();
/*     */     
/*     */     abstract void render(Renderer param1Renderer, ShadowBatch param1ShadowBatch, RenderData param1RenderData);
/*     */   }
/*     */   
/*     */   private boolean testArtillery(ArtilleryInstance ins, int cx, int cy, Trajectory traj) {
/* 154 */     CharSequence s = ins.testTarget(cx, cy, traj, true);
/* 155 */     if (s == null || s == SProjectiles.¤¤FRIENDLIES)
/* 156 */       return true; 
/* 157 */     return false;
/*     */   }
/*     */   public BattlePlacerAttack(GameWindow w, DivSelection s, BattlePlacer.Action a) {
/* 160 */     this.div = new Target(this)
/*     */       {
/*     */         private Div target;
/*     */ 
/*     */ 
/*     */         
/*     */         boolean set() {
/* 167 */           this.target = null;
/* 168 */           ENTITY e = SETT.ENTITIES().getArroundPoint(BattlePlacerAttack.this.w.pixel().x(), BattlePlacerAttack.this.w.pixel().y());
/* 169 */           if (e instanceof Humanoid) {
/* 170 */             Div d = ((Humanoid)e).division();
/* 171 */             if (d != null && d.army() == GAME.ARMIES().enemy()) {
/* 172 */               this.target = d;
/* 173 */               BattlePlacerAttack.this.s.hover(this.target);
/*     */             } 
/*     */           } 
/*     */           
/* 177 */           if (this.target == null)
/* 178 */             return false; 
/* 179 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         CharSequence name() {
/* 184 */           if (BattlePlacerAttack.this.melees && (BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery))
/* 185 */             return (CharSequence)Str.TMP.clear().add(BattlePlacerAttack.¤¤AttackMix).s().add(BattlePlacerAttack.¤¤AttackRangedDesc).insert(0, (KEYS.MAIN()).MOD.repr()); 
/* 186 */           if (BattlePlacerAttack.this.melees)
/* 187 */             return BattlePlacerAttack.¤¤AttackMelee; 
/* 188 */           return (CharSequence)Str.TMP.clear().add(BattlePlacerAttack.¤¤AttackRanged).s().add(BattlePlacerAttack.¤¤AttackRangedDesc).insert(0, (KEYS.MAIN()).MOD.repr());
/*     */         }
/*     */ 
/*     */         
/*     */         void problem(GBox b) {
/* 193 */           BattlePlacerAttack.this.artilleryProb(this.target.reporter.body().cX(), this.target.reporter.body().cY(), true, b);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         void click() {
/* 200 */           for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 201 */             if (BattlePlacerAttack.this.archers && dd.settings().ammo() != null) {
/* 202 */               BattlePlacerAttack.this.task.attackRanged(this.target, dd);
/*     */             } else {
/* 204 */               BattlePlacerAttack.this.task.attackMelee(this.target, dd);
/*     */             } 
/* 206 */             (dd.order()).task.set((Copyable)BattlePlacerAttack.this.task);
/*     */           } 
/* 208 */           if (BattlePlacerAttack.this.artillery) {
/* 209 */             for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 210 */               if (BattlePlacerAttack.this.testArtillery(ins, this.target.reporter.body().cX(), this.target.reporter.body().cY(), BattlePlacerAttack.this.traj)) {
/* 211 */                 ins.targetDivSet(this.target, true);
/*     */               }
/*     */             } 
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 219 */           BattlePlacerAttack.this.s.hover(this.target);
/* 220 */           BattleRenderer.colAttack.bind();
/*     */           
/* 222 */           Icon icon = (UI.icons()).l.swords;
/*     */           
/* 224 */           if (BattlePlacerAttack.this.melees && (BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery)) {
/* 225 */             Icon icon1 = ((int)(VIEW.renderSecond() * 2.0D) % 2 == 1) ? (SPRITES.icons()).m.bow : (SPRITES.icons()).m.sword;
/* 226 */             icon = ((int)(VIEW.renderSecond() * 2.0D) % 2 == 1) ? (UI.icons()).l.crossheir : (UI.icons()).l.swords;
/* 227 */             VIEW.mouse().setReplacement((SPRITE)icon1);
/* 228 */           } else if (BattlePlacerAttack.this.melees) {
/* 229 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */           } else {
/* 231 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/* 232 */             icon = (UI.icons()).l.crossheir;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 237 */           if (BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery) {
/* 238 */             int i; boolean someInRange = false;
/* 239 */             boolean allInRange = true;
/* 240 */             for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 241 */               if (dd.menNrOf() > 0 && dd.settings().ammo() != null) {
/* 242 */                 if (SProjectiles.problem(dd, this.target) == null) {
/* 243 */                   i = someInRange | true; continue;
/*     */                 } 
/* 245 */                 allInRange = false;
/*     */               } 
/*     */             } 
/*     */             
/* 249 */             for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 250 */               if (BattlePlacerAttack.this.testArtillery(ins, this.target.reporter.body().cX(), this.target.reporter.body().cY(), BattlePlacerAttack.this.traj)) {
/* 251 */                 i |= 0x1; continue;
/*     */               } 
/* 253 */               allInRange = false;
/*     */             } 
/*     */             
/* 256 */             if (i == 0 && !BattlePlacerAttack.this.archers && BattlePlacerAttack.this.artillery) {
/* 257 */               VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */               return;
/*     */             } 
/* 260 */             if (!allInRange) {
/* 261 */               COLOR.ORANGE100.bind();
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 266 */           int cx = this.target.centre().cX() - data.offX1();
/* 267 */           int cy = this.target.centre().cY() - data.offY1();
/*     */           
/* 269 */           icon.renderCScaled((SPRITE_RENDERER)r, cx, cy, 8);
/*     */ 
/*     */ 
/*     */           
/* 273 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 278 */     this.room = new Target(this)
/*     */       {
/*     */         private Room r;
/*     */         
/*     */         private int cx;
/*     */         private int cy;
/*     */         
/*     */         boolean set() {
/* 286 */           if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery) {
/* 287 */             this.r = (Room)(SETT.ROOMS()).map.get((COORDINATE)BattlePlacerAttack.this.w.tile());
/* 288 */             if (this.r != null) {
/* 289 */               FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)BattlePlacerAttack.this.w.tile());
/* 290 */               if (it != null) {
/* 291 */                 COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1((COORDINATE)BattlePlacerAttack.this.w.tile(), Coo.TMP);
/* 292 */                 this.cx = c.x() * 64 + it.width() * 64 / 2;
/* 293 */                 this.cy = c.y() * 64 + it.height() * 64 / 2;
/* 294 */                 return true;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 300 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         CharSequence name() {
/* 305 */           if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 306 */             return BattlePlacerAttack.¤¤AttackBuilding;
/*     */           }
/* 308 */           return BattlePlacerAttack.¤¤BombardBuilding;
/*     */         }
/*     */ 
/*     */         
/*     */         void problem(GBox b) {
/* 313 */           BattlePlacerAttack.this.artilleryProb(this.cx, this.cy, false, b);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         void click() {
/* 320 */           for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 321 */             BattlePlacerAttack.this.task.attack(this.cx / 64, this.cy / 64, dd);
/* 322 */             (dd.order()).task.set((Copyable)BattlePlacerAttack.this.task);
/*     */           } 
/* 324 */           if (BattlePlacerAttack.this.artillery) {
/* 325 */             for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 326 */               if (ins.testTarget(this.cx, this.cy, BattlePlacerAttack.this.traj, false) == null) {
/* 327 */                 ins.targetCooSet(this.cx, this.cy, false, true);
/*     */               }
/*     */             } 
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 336 */           COLOR.RED100.bind();
/*     */           
/* 338 */           if ((BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) && BattlePlacerAttack.this.artillery) {
/* 339 */             VIEW.mouse().setReplacement(((int)VIEW.renderSecond() * 2 % 2 == 1) ? (SPRITE)(SPRITES.icons()).m.bow : (SPRITE)(SPRITES.icons()).m.sword);
/* 340 */           } else if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 341 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */           } else {
/* 343 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/*     */           } 
/*     */ 
/*     */           
/* 347 */           int p = BattlePlacerAttack.this.artilleryProblem(this.cx, this.cy, false);
/* 348 */           if (p == 0) {
/* 349 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */             return;
/*     */           } 
/* 352 */           if (p == 1) {
/* 353 */             COLOR.ORANGE100.bind();
/*     */           }
/* 355 */           FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)BattlePlacerAttack.this.w.tile());
/* 356 */           if (it != null) {
/* 357 */             COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1((COORDINATE)BattlePlacerAttack.this.w.tile(), Coo.TMP);
/* 358 */             int x1 = c.x() * 64 - data.offX1();
/* 359 */             int y1 = c.y() * 64 - data.offY1();
/* 360 */             (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, x1, y1, it.width() * 64, it.height() * 64);
/* 361 */             COLOR.unbind();
/*     */             
/*     */             return;
/*     */           } 
/*     */         }
/*     */       };
/* 367 */     this.building = new Target(this)
/*     */       {
/*     */         private int cx;
/*     */         
/*     */         private int cy;
/*     */         
/*     */         boolean set() {
/* 374 */           if ((BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery) && 
/* 375 */             (GAME.ARMIES()).map.attackable.is((COORDINATE)BattlePlacerAttack.this.w.tile(), GAME.ARMIES().player())) {
/* 376 */             this.cx = BattlePlacerAttack.this.w.tile().x() * 64 + 32;
/* 377 */             this.cy = BattlePlacerAttack.this.w.tile().y() * 64 + 32;
/* 378 */             return true;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 383 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         CharSequence name() {
/* 388 */           if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 389 */             return BattlePlacerAttack.¤¤AttackBuilding;
/*     */           }
/* 391 */           return BattlePlacerAttack.¤¤BombardBuilding;
/*     */         }
/*     */ 
/*     */         
/*     */         void problem(GBox b) {
/* 396 */           BattlePlacerAttack.this.artilleryProb(this.cx, this.cy, false, b);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void click() {
/* 402 */           for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 403 */             BattlePlacerAttack.this.task.attack(this.cx >> 6, this.cy >> 6, dd);
/* 404 */             (dd.order()).task.set((Copyable)BattlePlacerAttack.this.task);
/*     */           } 
/* 406 */           if (BattlePlacerAttack.this.artillery) {
/* 407 */             for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 408 */               if (ins.testTarget(this.cx, this.cy, BattlePlacerAttack.this.traj, false) == null) {
/* 409 */                 ins.targetCooSet(this.cx, this.cy, false, true);
/*     */               }
/*     */             } 
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 418 */           COLOR.RED100.bind();
/*     */           
/* 420 */           if ((BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) && BattlePlacerAttack.this.artillery) {
/* 421 */             VIEW.mouse().setReplacement(((int)VIEW.renderSecond() * 2 % 2 == 1) ? (SPRITE)(SPRITES.icons()).m.bow : (SPRITE)(SPRITES.icons()).m.sword);
/* 422 */           } else if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 423 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */           } else {
/* 425 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/*     */           } 
/* 427 */           int p = BattlePlacerAttack.this.artilleryProblem(this.cx, this.cy, false);
/* 428 */           if (p == 0) {
/* 429 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */             return;
/*     */           } 
/* 432 */           if (p == 1) {
/* 433 */             COLOR.ORANGE100.bind();
/*     */           }
/*     */           
/* 436 */           int x1 = this.cx - data.offX1();
/* 437 */           int y1 = this.cy - data.offY1();
/* 438 */           (SPRITES.cons()).BIG.dots.renderCentered((SPRITE_RENDERER)r, 0, x1, y1);
/* 439 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 514 */     this.ground = new Target(this)
/*     */       {
/*     */         boolean set()
/*     */         {
/* 518 */           if (!BattlePlacerAttack.this.artillery) {
/* 519 */             return false;
/*     */           }
/* 521 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         CharSequence name() {
/* 526 */           return BattlePlacerAttack.¤¤BombardArea;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void problem(GBox b) {
/* 532 */           BattlePlacerAttack.this.artilleryProb(BattlePlacerAttack.this.w.pixel().x(), BattlePlacerAttack.this.w.pixel().y(), false, b);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void click() {
/* 538 */           for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 539 */             if (ins.testTarget(BattlePlacerAttack.this.w.pixel().x(), BattlePlacerAttack.this.w.pixel().y(), BattlePlacerAttack.this.traj, false) == null) {
/* 540 */               ins.targetCooSet(BattlePlacerAttack.this.w.pixel().x(), BattlePlacerAttack.this.w.pixel().y(), true, true);
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/*     */         void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 546 */           int p = BattlePlacerAttack.this.artilleryProblem(BattlePlacerAttack.this.w.pixel().x(), BattlePlacerAttack.this.w.pixel().y(), false);
/* 547 */           if (p == 0) {
/* 548 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */             return;
/*     */           } 
/* 551 */           if (p == 1) {
/* 552 */             COLOR.ORANGE100.bind();
/*     */           } else {
/* 554 */             COLOR.RED100.bind();
/* 555 */           }  VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/* 556 */           int d = 192;
/* 557 */           int x1 = BattlePlacerAttack.this.w.pixel().x() - d / 2 - data.offX1();
/* 558 */           int y1 = BattlePlacerAttack.this.w.pixel().y() - d / 2 - data.offY1();
/*     */           
/* 560 */           (SPRITES.cons()).BIG.dots.renderBox((SPRITE_RENDERER)r, x1, y1, d, d);
/*     */         }
/*     */       };
/*     */     this.w = w;
/*     */     this.s = s;
/*     */     this.a = a;
/*     */   }
/*     */   
/*     */   private int artilleryProblem(int cx, int cy, boolean ent) {
/*     */     if (this.artillery) {
/*     */       int ok = 0;
/*     */       for (ArtilleryInstance ins : this.s.artillery.selection()) {
/*     */         if (ins.testTarget(cx, cy, this.traj, ent) == null)
/*     */           ok++; 
/*     */       } 
/*     */       if (ok < this.s.artillery.selection().size()) {
/*     */         if (ok == 0)
/*     */           return 0; 
/*     */         return 1;
/*     */       } 
/*     */     } 
/*     */     return 2;
/*     */   }
/*     */   
/*     */   private void artilleryProb(int cx, int cy, boolean ent, GBox b) {
/*     */     int am = 0;
/*     */     if (this.archers)
/*     */       for (Div dd : this.s.selection()) {
/*     */         if (dd.menNrOf() > 0 && dd.settings().ammo() != null) {
/*     */           CharSequence s = SProjectiles.problem(this.traj, dd, cx, cy);
/*     */           if (s != null) {
/*     */             am++;
/*     */             if (am > 10) {
/*     */               GText t = b.text();
/*     */               t.errorify().add(Dic.¤¤More).add('.').add('.').add('.');
/*     */               b.add((SPRITE)t);
/*     */               b.NL();
/*     */               break;
/*     */             } 
/*     */             b.add((SPRITE)(SPRITES.icons()).s.bow);
/*     */             b.error(s);
/*     */             b.NL();
/*     */           } 
/*     */         } 
/*     */       }  
/*     */     am = 0;
/*     */     if (this.artillery)
/*     */       for (ArtilleryInstance ins : this.s.artillery.selection()) {
/*     */         CharSequence s = ins.testTarget(cx, cy, this.traj, ent);
/*     */         if (s != null) {
/*     */           am++;
/*     */           if (am > 10) {
/*     */             GText t = b.text();
/*     */             t.errorify().add(Dic.¤¤More).add('.').add('.').add('.');
/*     */             b.add((SPRITE)t);
/*     */             b.NL();
/*     */             break;
/*     */           } 
/*     */           b.add((SPRITE)(SPRITES.icons()).s.circle);
/*     */           b.error(s);
/*     */           b.NL();
/*     */         } 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerAttack.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */