/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import game.audio.AUDIO;
/*    */ import game.audio.SoundRace;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends TerrainClearing
/*    */ {
/* 54 */   private final SoundRace sound = AUDIO.race("CLEAR_BUSH");
/*    */ 
/*    */ 
/*    */   
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 59 */     TGrowable.this.size.increment(tx, ty, -3);
/*    */     
/* 61 */     if ((SETT.WEATHER()).growthRipe.cropsAreRipe())
/* 62 */       return TGrowable.this.growable.resource; 
/* 63 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 68 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 73 */     int am = (int)Math.ceil(TGrowable.this.resource.get(tx, ty) / 4.0D);
/* 74 */     TGrowable.this.shared.NADA.placeFixed(tx, ty);
/* 75 */     return am;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 80 */     return this.sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEasilyCleared() {
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TGrowable$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */