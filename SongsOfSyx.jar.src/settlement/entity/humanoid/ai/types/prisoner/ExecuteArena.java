/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanGladiator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.arena.RoomArenaWork;
/*     */ import settlement.room.service.arena.grand.ROOM_ARENA;
/*     */ import settlement.room.service.arena.pit.ROOM_FIGHTPIT;
/*     */ import settlement.stats.STATS;
/*     */ import util.text.D;
/*     */ 
/*     */ class ExecuteArena
/*     */   extends AIPlanGladiator {
/*  18 */   private static CharSequence ¤¤name = "¤Fighting to death in the arena.";
/*     */   
/*     */   static {
/*  21 */     D.ts(ExecuteArena.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecuteArena() {
/*  26 */     super("PRisArena", true, ¤¤name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*  32 */     d.planByte3 = 0;
/*     */     
/*  34 */     (NEEDS.TYPES()).HUNGER.stat().fixMax(a.indu());
/*  35 */     (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/*     */     
/*  37 */     for (ROOM_ARENA arena : (SETT.ROOMS()).GARENAS) {
/*  38 */       if (arena.punishEnabled().is(a.race())) {
/*  39 */         RoomInstance ins = arena.work.reserveDeath(a.tc());
/*  40 */         if (ins != null) {
/*  41 */           d.planTile.set(arena.work.gladiatorGetSpot(ins));
/*  42 */           return super.init(a, d);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  47 */       d.planByte3 = (byte)(d.planByte3 + 1);
/*     */     } 
/*     */     
/*  50 */     for (ROOM_FIGHTPIT arena : (SETT.ROOMS()).FIGHTPITS) {
/*  51 */       if (arena.punishEnabled().is(a.race())) {
/*  52 */         RoomInstance ins = arena.work.reserveDeath(a.tc());
/*  53 */         if (ins != null) {
/*  54 */           d.planTile.set(arena.work.gladiatorGetSpot(ins));
/*  55 */           return super.init(a, d);
/*     */         } 
/*     */       } 
/*     */       
/*  59 */       d.planByte3 = (byte)(d.planByte3 + 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected RoomArenaWork w(Humanoid a, AIManager d) {
/*  69 */     if (d.planByte3 >= (SETT.ROOMS()).GARENAS.size()) {
/*  70 */       return ((ROOM_FIGHTPIT)(SETT.ROOMS()).FIGHTPITS.get(d.planByte3 - (SETT.ROOMS()).GARENAS.size())).work;
/*     */     }
/*  72 */     return ((ROOM_ARENA)(SETT.ROOMS()).GARENAS.get(d.planByte3)).work;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) {
/*  77 */     AISUB.AISubActivation sub = super.resume(a, d);
/*  78 */     if (sub == null) {
/*  79 */       w(a, d).unreserveDeath(d.planTile.x(), d.planTile.y());
/*  80 */       d.planTile.set(-1.0D, -1.0D);
/*  81 */       RoomInstance ins = w(a, d).reserveDeath(a.tc());
/*  82 */       if (ins != null) {
/*  83 */         d.planTile.set(w(a, d).gladiatorGetSpot(ins));
/*  84 */         return super.init(a, d);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  89 */     return sub;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/*  94 */     RoomArenaWork w = w(a, d);
/*  95 */     if (w != null)
/*  96 */       w.unreserveDeath(d.planTile.x(), d.planTile.y()); 
/*  97 */     d.planTile.set(-1.0D, -1.0D);
/*  98 */     super.cancel(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void remove(Humanoid a, AIManager d) {
/* 103 */     super.remove(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\ExecuteArena.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */