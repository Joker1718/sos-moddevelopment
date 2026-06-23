/*    */ package init.trade;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.trade.PBuyer;
/*    */ import settlement.trade.PSeller;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.common.IconHaser;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public abstract class TRADABLE
/*    */   extends INFO implements MAPPED, IconHaser {
/*    */   private final String key;
/*    */   private final int index;
/*    */   private final SPRITE icon;
/*    */   
/*    */   TRADABLE(String key, int index, INFO info, SPRITE icon) {
/* 18 */     super(info.name, info.names, info.desc, null);
/* 19 */     this.key = key;
/* 20 */     this.index = index;
/* 21 */     this.icon = icon;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 26 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 31 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE icon() {
/* 36 */     return this.icon;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 41 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PBuyer pb() {
/* 47 */     return SETT.TRADE().buyer(this);
/*    */   }
/*    */   
/*    */   public PSeller ps() {
/* 51 */     return SETT.TRADE().seller(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 58 */     return this.key + "[" + this.key + "]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\trade\TRADABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */