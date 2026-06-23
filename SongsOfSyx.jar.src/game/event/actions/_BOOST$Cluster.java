/*     */ package game.event.actions;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Cluster
/*     */   extends Booster
/*     */   implements BValue
/*     */ {
/* 230 */   private int upI = -1;
/* 231 */   private final ArrayListGrower<_BOOST.ClusterEntry> bplayer = new ArrayListGrower();
/* 232 */   private final ArrayListGrower<_BOOST.ClusterEntry> bregion = new ArrayListGrower();
/* 233 */   private final ArrayListGrower<_BOOST.ClusterEntry> bindu = new ArrayListGrower();
/*     */   
/*     */   private double player;
/*     */   
/*     */   private double reg;
/*     */   private double indu;
/* 239 */   private double from = 0.0D;
/* 240 */   private double to = 0.0D;
/*     */   private final double def;
/*     */   private final Boostable target;
/*     */   
/*     */   public Cluster(Boostable target, boolean isMul) {
/* 245 */     super(new BSourceInfo(Dic.¤¤Event, (SPRITE)(UI.icons()).s.time), isMul);
/* 246 */     if (isMul) {
/* 247 */       this.from = 1.0D;
/* 248 */       this.to = 1.0D;
/* 249 */       this.def = 1.0D;
/*     */     } else {
/* 251 */       this.def = 0.0D;
/*     */     } 
/* 253 */     this.target = target;
/*     */   }
/*     */   
/*     */   void addA(_BOOST.Imp b) {
/* 257 */     for (BoostSpec s : b.player.all()) {
/* 258 */       if (s.boostable == this.target && s.booster.isMul == this.isMul) {
/* 259 */         add(new _BOOST.ClusterEntry(b, s.booster.to()), this.bplayer);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   void addB(_BOOST.Imp b) {
/* 265 */     for (BoostSpec s : b.subjects.all()) {
/* 266 */       if (s.boostable == this.target && s.booster.isMul == this.isMul) {
/* 267 */         add(new _BOOST.ClusterEntry(b, s.booster.to()), this.bindu);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   void addC(_BOOST.Imp b) {
/* 273 */     for (BoostSpec s : b.regions.all()) {
/* 274 */       if (s.boostable == this.target && s.booster.isMul == this.isMul) {
/* 275 */         add(new _BOOST.ClusterEntry(b, s.booster.to()), this.bregion);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void add(_BOOST.ClusterEntry b, ArrayListGrower<_BOOST.ClusterEntry> li) {
/* 282 */     li.add(b);
/*     */     
/* 284 */     if ((this.isMul && b.value < 1.0D) || b.value < 0.0D) {
/* 285 */       this.from = Math.min(this.from, b.value);
/*     */     } else {
/* 287 */       this.to = Math.max(this.to, b.value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void cache() {
/* 293 */     if (this.upI == GAME.updateI())
/*     */       return; 
/* 295 */     this.upI = GAME.updateI();
/* 296 */     this.player = this.def;
/* 297 */     this.indu = this.def;
/* 298 */     this.reg = this.def;
/*     */     
/* 300 */     if (this.isMul) {
/* 301 */       for (_BOOST.ClusterEntry e : this.bplayer) {
/* 302 */         if (isActive(e)) {
/* 303 */           this.player *= e.value;
/*     */         }
/*     */       } 
/*     */       
/* 307 */       for (_BOOST.ClusterEntry e : this.bindu) {
/* 308 */         if (isActive(e)) {
/* 309 */           this.indu *= e.value;
/*     */         }
/*     */       } 
/*     */       
/* 313 */       for (_BOOST.ClusterEntry e : this.bregion) {
/* 314 */         if (isActive(e)) {
/* 315 */           this.reg *= e.value;
/*     */         }
/*     */       } 
/*     */       
/* 319 */       this.indu = this.indu * this.player - this.player;
/* 320 */       this.reg = this.reg * this.player - this.player;
/*     */     } else {
/*     */       
/* 323 */       for (_BOOST.ClusterEntry e : this.bplayer) {
/* 324 */         if (isActive(e)) {
/* 325 */           this.player += e.value;
/*     */         }
/*     */       } 
/* 328 */       for (_BOOST.ClusterEntry e : this.bregion) {
/* 329 */         if (isActive(e)) {
/* 330 */           this.reg += e.value;
/*     */         }
/*     */       } 
/* 333 */       for (_BOOST.ClusterEntry e : this.bindu) {
/* 334 */         if (isActive(e))
/* 335 */           this.indu += e.value; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isActive(_BOOST.ClusterEntry e) {
/* 341 */     if (e.imp.choice == null)
/* 342 */       return (GAME.EVENT().current() == e.imp.parent); 
/* 343 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 348 */     return input;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/* 353 */     return o.boostableValue(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/* 358 */     if (f == FACTIONS.player())
/* 359 */       return vGet(HCLASS_RACE.clP()); 
/* 360 */     return this.def;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 365 */     cache();
/* 366 */     return this.player + (((RD.event()).ii.get(reg) == 1) ? this.reg : 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 371 */     cache();
/* 372 */     return this.player + (STATS.EVENT().has(indu) ? this.indu : 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 377 */     if (div.army().faction() == FACTIONS.player()) {
/* 378 */       cache();
/* 379 */       return this.player + STATS.EVENT().stat().div().getD(div) * this.indu;
/*     */     } 
/* 381 */     return this.def;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE popTime) {
/* 386 */     cache();
/* 387 */     return this.player + STATS.EVENT().stat().data(popTime.cl).getD(popTime.race) * this.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 392 */     cache();
/* 393 */     return this.player;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 398 */     return this.def;
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/* 403 */     return this.from;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/* 408 */     return this.to;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_BOOST$Cluster.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */