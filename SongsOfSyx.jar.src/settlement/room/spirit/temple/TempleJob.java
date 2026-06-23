/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ public abstract class TempleJob {
/*     */   protected final ROOM_TEMPLE blue;
/*     */   protected TempleInstance ins;
/*  19 */   protected final Coo coo = new Coo();
/*     */   protected TempleAltar altar;
/*     */   
/*     */   private TempleJob(ROOM_TEMPLE blue) {
/*  23 */     this.blue = blue;
/*     */   }
/*     */   
/*     */   TempleJob get(int tx, int ty) {
/*  27 */     this.ins = (TempleInstance)this.blue.get(tx, ty);
/*  28 */     if (this.ins != null && 
/*  29 */       (SETT.ROOMS()).fData.tile.is(tx, ty, this.blue.constructor.ap)) {
/*  30 */       this.coo.set(tx, ty);
/*  31 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  32 */         int dx = tx + ((DIR)DIR.ORTHO.get(di)).x();
/*  33 */         int dy = ty + ((DIR)DIR.ORTHO.get(di)).y();
/*  34 */         if (this.ins.is(dx, dy) && this.blue.altar.get(dx, dy) != null) {
/*  35 */           this.altar = this.blue.altar.get(dx, dy);
/*     */         }
/*     */       } 
/*  38 */       return this;
/*     */     } 
/*     */     
/*  41 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void jobReserve();
/*     */ 
/*     */   
/*     */   public abstract boolean jobReservedIs();
/*     */ 
/*     */   
/*     */   public abstract void jobReserveCancel();
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  56 */     return this.blue.employment().sound();
/*     */   } public abstract RBIT jobResourceBitToFetch(); public abstract void jobStartPerforming();
/*     */   public abstract void jobPerform(Humanoid paramHumanoid, int paramInt);
/*     */   public COORDINATE coo() {
/*  60 */     return (COORDINATE)this.coo;
/*     */   }
/*     */   
/*     */   public COORDINATE faceCoo() {
/*  64 */     return this.altar.coo();
/*     */   }
/*     */   
/*     */   public CharSequence jobName() {
/*  68 */     return (this.blue.employment()).verb;
/*     */   }
/*     */   
/*     */   public boolean shouldKill() {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void kill() {}
/*     */ 
/*     */   
/*     */   public void reportMissingResource() {
/*  80 */     this.ins.resHas = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class Resources
/*     */     extends TempleJob
/*     */   {
/*  88 */     private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, 1);
/*     */     
/*     */     private final RESOURCE res;
/*     */     
/*     */     Resources(ROOM_TEMPLE blue, RESOURCE resources) {
/*  93 */       super(blue);
/*  94 */       this.res = resources;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve() {
/*  99 */       this.reserved.set((ROOMA)this.ins, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs() {
/* 104 */       return (this.reserved.get() == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel() {
/* 109 */       this.reserved.set((ROOMA)this.ins, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 114 */       if (this.altar.resourceNeeds()) {
/* 115 */         return this.res.bit;
/*     */       }
/* 117 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobPerform(Humanoid skill, int res) {
/* 127 */       jobReserveCancel();
/* 128 */       if (res > 0) {
/* 129 */         this.altar.resourceInc(res);
/* 130 */         FACTIONS.player().res().inc(this.res, FResources.RTYPE.CONSUMED, -res);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean shouldKill() {
/* 136 */       return this.altar.shouldKill();
/*     */     }
/*     */ 
/*     */     
/*     */     public void kill() {
/* 141 */       this.altar.kill();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 147 */       return this.blue.employment().sound();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static final class None
/*     */     extends TempleJob
/*     */   {
/* 155 */     private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, 1);
/*     */     
/*     */     None(ROOM_TEMPLE blue) {
/* 158 */       super(blue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve() {
/* 163 */       this.reserved.set((ROOMA)this.ins, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs() {
/* 168 */       return (this.reserved.get() == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel() {
/* 173 */       this.reserved.set((ROOMA)this.ins, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 178 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobPerform(Humanoid skill, int res) {
/* 188 */       jobReserveCancel();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean shouldKill() {
/* 193 */       return this.altar.shouldKill();
/*     */     }
/*     */ 
/*     */     
/*     */     public void kill() {
/* 198 */       this.altar.kill();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 204 */       return this.blue.employment().sound();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleJob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */