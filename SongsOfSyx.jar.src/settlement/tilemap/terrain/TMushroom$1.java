/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import game.audio.AUDIO;
/*    */ import game.audio.SoundRace;
/*    */ import init.resources.RESOURCE;
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
/* 39 */   private final SoundRace sound = AUDIO.race("CLEAR_BUSH");
/*    */ 
/*    */   
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 43 */     TMushroom.this.shared.NADA.placeFixed(tx, ty);
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 54 */     TMushroom.this.shared.NADA.placeFixed(tx, ty);
/* 55 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 60 */     return this.sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEasilyCleared() {
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMushroom$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */