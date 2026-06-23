/*    */ package init.type;
/*    */ 
/*    */ import init.INIT;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public final class TYPEINIT
/*    */   extends INIT.InitResource
/*    */ {
/*    */   public TYPEINIT(INIT init) throws IOException {
/* 11 */     super(init);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 20 */     WGROUP.init();
/* 21 */     HGROUP.init();
/* 22 */     HCLASS_RACE.init(null, null);
/* 23 */     HTYPE_RACE.init(null, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TYPEINIT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */