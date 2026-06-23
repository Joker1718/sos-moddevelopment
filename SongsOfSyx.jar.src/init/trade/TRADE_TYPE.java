/*    */ package init.trade;
/*    */ 
/*    */ import game.faction.FCredits;
/*    */ import game.faction.FResources;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class TRADE_TYPE
/*    */ {
/* 10 */   private static final ArrayListGrower<TRADE_TYPE> pall = new ArrayListGrower();
/*    */   
/* 12 */   public static final LIST<TRADE_TYPE> all = (LIST<TRADE_TYPE>)pall;
/*    */   
/* 14 */   public static final TRADE_TYPE tax = new TRADE_TYPE(FResources.RTYPE.TAX, FCredits.CTYPE.TAX);
/* 15 */   public static final TRADE_TYPE trade = new TRADE_TYPE(FResources.RTYPE.TRADE, FCredits.CTYPE.TRADE);
/* 16 */   public static final TRADE_TYPE spoils = new TRADE_TYPE(FResources.RTYPE.SPOILS, FCredits.CTYPE.TRIBUTE);
/* 17 */   public static final TRADE_TYPE diplomacy = new TRADE_TYPE(FResources.RTYPE.DIPLOMACY, FCredits.CTYPE.DIPLOMACY);
/*    */   
/*    */   public final CharSequence name;
/*    */   public final int index;
/*    */   public final FResources.RTYPE rtype;
/*    */   public final FCredits.CTYPE ctype;
/*    */   
/*    */   private TRADE_TYPE(FResources.RTYPE rtype, FCredits.CTYPE ctype) {
/* 25 */     this.name = rtype.name;
/* 26 */     this.index = pall.add(this);
/* 27 */     this.rtype = rtype;
/* 28 */     this.ctype = ctype;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\trade\TRADE_TYPE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */