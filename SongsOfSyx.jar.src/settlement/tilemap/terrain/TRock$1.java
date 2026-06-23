/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import game.audio.AUDIO;
/*    */ import game.audio.SoundRace;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
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
/* 41 */   private final SoundRace sound = AUDIO.race("CLEAR_STONE");
/*    */ 
/*    */   
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 45 */     TRock.this.amountDecrease(tx, ty);
/* 46 */     return RESOURCES.STONE();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 56 */     int a = TRock.this.amountGet(TRock.this.shared.data.get(tx, ty));
/* 57 */     TRock.this.shared.NADA.placeFixed(tx, ty);
/* 58 */     return a;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 63 */     return this.sound;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TRock$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */