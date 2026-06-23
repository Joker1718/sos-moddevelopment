/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.thread.general.Strategos2000Updater;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.Config;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public class Strategos2000UpdaterOffense
/*     */   extends Strategos2000Updater
/*     */ {
/*     */   private final LIST<State> states;
/*     */   private final StrategosUtil u;
/*     */   private int state;
/*     */   private final Context c;
/*     */   
/*     */   public Strategos2000UpdaterOffense(StrategosUtil u) {
/*  34 */     this.u = u;
/*  35 */     this.c = new Context();
/*  36 */     this.states = attack();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  41 */     this.state = 0;
/*  42 */     this.c.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  47 */     file.i(this.state);
/*  48 */     this.c.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  53 */     this.state = file.i();
/*  54 */     this.c.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update() {
/*  60 */     if (this.state >= this.states.size()) {
/*  61 */       this.state = 0;
/*  62 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  66 */     int s = this.state;
/*  67 */     long millis = System.currentTimeMillis();
/*     */     
/*  69 */     if (!((State)this.states.get(this.state)).is()) {
/*  70 */       this.state++;
/*     */     }
/*  72 */     millis = System.currentTimeMillis() - millis;
/*     */     
/*  74 */     return true;
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
/*     */   public void render(Renderer r, RenderData.RenderIterator it) {
/*  87 */     if (this.c.blob.is(it.tile())) {
/*  88 */       COLOR.ORANGE100.bind();
/*  89 */       (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */     } 
/*  91 */     if (this.c.block.is(it.tile())) {
/*  92 */       COLOR.WHITE50.bind();
/*  93 */       (UI.icons()).s.cancel.renderScaled((SPRITE_RENDERER)r, it.x(), it.y(), 4);
/*     */     } 
/*     */     
/*  96 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 102 */     for (int li = 0; li < this.c.lines.lines(); li++) {
/* 103 */       ContextLines.Line l = this.c.lines.get(li);
/* 104 */       int ox = data.offX1();
/* 105 */       int oy = data.offY1();
/*     */       
/* 107 */       for (int s = 0; s <= l.length; s += 32) {
/* 108 */         int cx = (int)(l.sx + l.dx * s - ox);
/* 109 */         int cy = (int)(l.sy + l.dy * s - oy);
/*     */         
/* 111 */         (UI.icons()).s.dot.renderC((SPRITE_RENDERER)r, cx, cy);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<State> attack() {
/* 120 */     ArrayListGrower<State> states = new ArrayListGrower();
/*     */     
/* 122 */     states.add(new State("clear")
/*     */         {
/* 124 */           private final BattleOrderTask task = new BattleOrderTask();
/*     */ 
/*     */           
/*     */           public boolean is() {
/* 128 */             Strategos2000UpdaterOffense.this.c.deployedToLine.clear();
/*     */             
/* 130 */             for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 131 */               Div d = (Div)Strategos2000UpdaterOffense.this.u.getArmy().divisions().get(di);
/* 132 */               if (d.active() && d.settings().ammo() != null && BattleTrajectories.trajectories(d) > d.men() / 2) {
/* 133 */                 (d.settings()).fireAtWill = true;
/* 134 */                 (d.settings()).formation = DIV_FORMATION.LOOSE;
/* 135 */                 this.task.stop(d);
/* 136 */                 (d.order()).task.set((Copyable)this.task);
/* 137 */                 Strategos2000UpdaterOffense.this.c.deployedToLine.set(di, true);
/*     */               } 
/*     */             } 
/*     */             
/* 141 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 145 */     states.add(new State("bombard")
/*     */         {
/* 147 */           StepArtilleryBombard b = new StepArtilleryBombard(Strategos2000UpdaterOffense.this.u);
/*     */ 
/*     */           
/*     */           public boolean is() {
/* 151 */             this.b.bombard();
/* 152 */             return false;
/*     */           }
/*     */         });
/* 155 */     states.add(new State("blob")
/*     */         {
/* 157 */           StepBlob s = new StepBlob(Strategos2000UpdaterOffense.this.u);
/*     */ 
/*     */           
/*     */           public boolean is() {
/* 161 */             this.s.update(Strategos2000UpdaterOffense.this.c.blob, 24);
/* 162 */             return false;
/*     */           }
/*     */         });
/* 165 */     states.add(new State("throne")
/*     */         {
/*     */           
/*     */           public boolean is()
/*     */           {
/* 170 */             return false;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 176 */     states.add(new State("make lines")
/*     */         {
/* 178 */           StepLinesMaker s = new StepLinesMaker(Strategos2000UpdaterOffense.this.u, Strategos2000UpdaterOffense.this.c);
/*     */ 
/*     */           
/*     */           public boolean is() {
/* 182 */             this.s.make();
/* 183 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 187 */     final StepLinesChecker check = new StepLinesChecker(this.u, this.c);
/* 188 */     states.add(new State("checkLines init")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 192 */             check.init();
/* 193 */             return false;
/*     */           }
/*     */         });
/* 196 */     states.add(new State("checkLines")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 200 */             return check.check();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 205 */     states.add(new State("blockLines")
/*     */         {
/* 207 */           StepLinesBlocker s = new StepLinesBlocker(Strategos2000UpdaterOffense.this.u, Strategos2000UpdaterOffense.this.c);
/*     */ 
/*     */           
/*     */           public boolean is() {
/* 211 */             this.s.make();
/* 212 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 216 */     final StepLinesBacker back = new StepLinesBacker(this.u, this.c);
/* 217 */     states.add(new State("back lines")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 221 */             back.init();
/* 222 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 226 */     states.add(new State("back lines 2")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 230 */             return back.retreatThroneLine();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 236 */     final StepLinesMoveTo line = new StepLinesMoveTo(this.u, this.c);
/* 237 */     states.add(new State("line move init")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 241 */             line.init();
/* 242 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 246 */     states.add(new State("line move 1")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 250 */             return line.deployDivsToLine();
/*     */           }
/*     */         });
/*     */     
/* 254 */     states.add(new State("line move 2")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 258 */             return line.deployDivsToLineRanged();
/*     */           }
/*     */         });
/*     */     
/* 262 */     states.add(new State("line move3")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 266 */             line.setSpeedAndFormation();
/*     */             
/* 268 */             return false;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 273 */     final StepLineCharge charge = new StepLineCharge(this.u, this.c);
/* 274 */     states.add(new State("charge 1")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 278 */             charge.init();
/* 279 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 283 */     states.add(new State("charge 2")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 287 */             return charge.charge();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 293 */     final StepMoveToThrone throne = new StepMoveToThrone(this.u, this.c);
/* 294 */     states.add(new State("throne init")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 298 */             throne.init();
/* 299 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 303 */     states.add(new State("throne")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 307 */             return throne.setToThrone();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 312 */     states.add(new State("attack") {
/* 313 */           StepAttackEnemyNear s = new StepAttackEnemyNear(Strategos2000UpdaterOffense.this.u, Strategos2000UpdaterOffense.this.c);
/*     */           
/*     */           public boolean is() {
/* 316 */             return this.s.attackEnemies();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 325 */     final StepAttackOthers kite = new StepAttackOthers(this.u, this.c);
/* 326 */     states.add(new State("kite init")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 330 */             kite.init();
/* 331 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 335 */     states.add(new State("kite")
/*     */         {
/*     */           public boolean is()
/*     */           {
/* 339 */             return kite.attack();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 360 */     return (LIST<State>)states;
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class State
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */     
/*     */     State(String name) {
/* 370 */       this.name = name;
/*     */     }
/*     */     
/*     */     public abstract boolean is();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\Strategos2000UpdaterOffense.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */