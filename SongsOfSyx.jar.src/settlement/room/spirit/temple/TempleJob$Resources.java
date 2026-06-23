/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
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
/*     */ final class Resources
/*     */   extends TempleJob
/*     */ {
/*  88 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, 1);
/*     */   
/*     */   private final RESOURCE res;
/*     */   
/*     */   Resources(ROOM_TEMPLE blue, RESOURCE resources) {
/*  93 */     super(blue);
/*  94 */     this.res = resources;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve() {
/*  99 */     this.reserved.set((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs() {
/* 104 */     return (this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel() {
/* 109 */     this.reserved.set((ROOMA)this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 114 */     if (this.altar.resourceNeeds()) {
/* 115 */       return this.res.bit;
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobPerform(Humanoid skill, int res) {
/* 127 */     jobReserveCancel();
/* 128 */     if (res > 0) {
/* 129 */       this.altar.resourceInc(res);
/* 130 */       FACTIONS.player().res().inc(this.res, FResources.RTYPE.CONSUMED, -res);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldKill() {
/* 136 */     return this.altar.shouldKill();
/*     */   }
/*     */ 
/*     */   
/*     */   public void kill() {
/* 141 */     this.altar.kill();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 147 */     return this.blue.employment().sound();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleJob$Resources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */