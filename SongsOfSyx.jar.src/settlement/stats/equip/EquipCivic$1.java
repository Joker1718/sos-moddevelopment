/*    */ package settlement.stats.equip;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
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
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 45 */     EquipCivic.this.tars.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 50 */     EquipCivic.this.tars.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 55 */     EquipCivic.this.tars.setAll(EquipCivic.this.targetDefault);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipCivic$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */