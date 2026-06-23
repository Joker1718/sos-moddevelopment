/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomState;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class State
/*     */   extends RoomState.RoomStateInstance
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private boolean fetching;
/*     */   private boolean prio;
/*     */   private final boolean broken;
/*     */   private MoveOrderPull[] orders;
/*     */   private final int ri;
/*     */   
/*     */   public State(ExportInstance ins, boolean broken) {
/* 210 */     super(ins);
/* 211 */     this.broken = broken;
/* 212 */     this.fetching = ins.fetching;
/* 213 */     this.prio = ins.prio;
/* 214 */     this.ri = ins.resourceI;
/* 215 */     if (broken) {
/* 216 */       this.orders = ins.orders;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyIns(RoomInstance ins) {
/* 223 */     if (ins instanceof ExportInstance) {
/* 224 */       if (this.ri != 0) {
/* 225 */         ((ExportInstance)ins).resourceSet((RESOURCE)RESOURCES.ALL().get(this.ri - 1));
/*     */       }
/* 227 */       ExportInstance s = (ExportInstance)ins;
/* 228 */       if (this.broken) {
/* 229 */         for (int i = 0; i < this.orders.length; i++) {
/* 230 */           if (this.orders[i] != null) {
/* 231 */             MoveOrderPull p = new MoveOrderPull(this.orders[i].destCoo(), (RBIT)(this.orders[i]).resbits);
/* 232 */             s.orders[i] = p;
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 238 */       if (this.fetching != s.fetching())
/* 239 */         s.fetchingSet(this.fetching); 
/* 240 */       if (this.prio != s.prio())
/* 241 */         s.prioSet(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\ExportInstance$State.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */