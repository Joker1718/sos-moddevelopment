/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Cache
/*     */ {
/* 351 */   private int upI = -1;
/*     */   
/*     */   private int treesTotal;
/*     */   
/*     */   private int trees;
/*     */   private int daysTillNextTree;
/*     */   private int wood;
/*     */   private double output;
/*     */   private Instance ins;
/*     */   
/*     */   public int treesTotal(Instance ins) {
/* 362 */     up(ins);
/* 363 */     return this.treesTotal;
/*     */   }
/*     */   
/*     */   public int trees(Instance ins) {
/* 367 */     up(ins);
/* 368 */     return this.trees;
/*     */   }
/*     */   
/*     */   public int daysTillNextTree(Instance ins) {
/* 372 */     up(ins);
/* 373 */     return this.daysTillNextTree;
/*     */   }
/*     */   
/*     */   public double output(Instance ins) {
/* 377 */     up(ins);
/* 378 */     return this.output;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void up(Instance ins) {
/* 385 */     if (this.upI == GAME.updateI() && this.ins == ins)
/*     */       return; 
/* 387 */     this.ins = ins;
/* 388 */     this.upI = GAME.updateI();
/*     */     
/* 390 */     this.wood = 0;
/*     */     
/* 392 */     this.treesTotal = 0;
/* 393 */     this.trees = 0;
/* 394 */     this.daysTillNextTree = Integer.MAX_VALUE;
/*     */     
/* 396 */     for (COORDINATE c : ins.body()) {
/* 397 */       if (!ins.is(c)) {
/*     */         continue;
/*     */       }
/* 400 */       OTile t = ((ROOM_ORCHARD)Gui.access$1(Gui.this)).tile.getM(c.x(), c.y());
/* 401 */       if (t != null) {
/* 402 */         this.treesTotal++;
/* 403 */         if (t.state() == t.IBIG) {
/* 404 */           this.trees++;
/*     */         } else {
/* 406 */           int d = t.state().daysTillGrown();
/* 407 */           if (d < this.daysTillNextTree)
/*     */           {
/* 409 */             this.daysTillNextTree = d;
/*     */           }
/*     */         } 
/* 412 */         if (t.state() == t.ISMALL) {
/* 413 */           this.wood += ((ROOM_ORCHARD)Gui.access$1(Gui.this)).auxRes.amount() / 2; continue;
/* 414 */         }  if (t.state() == t.IBIG || t.state() == t.IDEAD) {
/* 415 */           this.wood += ((ROOM_ORCHARD)Gui.access$1(Gui.this)).auxRes.amount();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 420 */     this.output = ((ROOM_ORCHARD)Gui.access$1(Gui.this)).time.days * ins.skill() * ins.base * ((IndustryResource)ins.industry().outs().get(0)).rate * ins.trees / ins.treesTotal;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Gui$Cache.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */