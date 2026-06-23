/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import init.race.bio.Opinion;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public class StatInfo
/*    */   extends INFO {
/*    */   private boolean isInt = false;
/*    */   private boolean matters = true;
/*    */   private boolean hasIndu = true;
/* 13 */   public Opinion defOpinion = Opinion.DEF;
/* 14 */   public SPRITE icon = null;
/*    */   
/*    */   public StatInfo(StatInfo other) {
/* 17 */     super(other.name, other.names, other.desc, null);
/* 18 */     this.isInt = other.isInt;
/* 19 */     this.matters = other.matters;
/* 20 */     this.hasIndu = other.hasIndu;
/* 21 */     this.defOpinion = other.defOpinion;
/* 22 */     this.icon = other.icon;
/*    */   }
/*    */   
/*    */   public StatInfo(Json json) {
/* 26 */     super(json);
/* 27 */     this.defOpinion = new Opinion();
/* 28 */     this.defOpinion.read(json);
/*    */   }
/*    */ 
/*    */   
/*    */   public StatInfo(CharSequence name, CharSequence desc) {
/* 33 */     super(name, desc);
/*    */   }
/*    */   
/*    */   public StatInfo(CharSequence name, CharSequence names, CharSequence desc) {
/* 37 */     super(name, names, desc, null);
/*    */   }
/*    */   
/*    */   public boolean isInt() {
/* 41 */     return this.isInt;
/*    */   }
/*    */   
/*    */   public void setInt() {
/* 45 */     this.isInt = true;
/*    */   }
/*    */   
/*    */   public void setOpinion(Opinion op) {
/* 49 */     this.defOpinion = op;
/*    */   }
/*    */   
/*    */   public void setOpinion(CharSequence more, CharSequence less) {
/* 53 */     this.defOpinion = (new Opinion()).setMore(new CharSequence[] { more }).setLess(new CharSequence[] { less });
/*    */   }
/*    */   
/*    */   public void setMatters(boolean matters, boolean hasIndu) {
/* 57 */     this.matters = matters;
/* 58 */     this.hasIndu = hasIndu;
/*    */   }
/*    */   
/*    */   public boolean indu() {
/* 62 */     return this.hasIndu;
/*    */   }
/*    */   
/*    */   public boolean matters() {
/* 66 */     return this.matters;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\StatInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */