/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import view.main.VIEW;
/*    */ import view.tool.PLACABLE;
/*    */ 
/*    */ public class UICopier {
/*  7 */   private final Source source = new Source();
/*  8 */   private final Dest dest = new Dest(this.source);
/*  9 */   private final Second second = new Second(this.dest);
/* 10 */   private final First first = new First(this.source);
/* 11 */   private final FirstConfig config = new FirstConfig(this.source, this.second, this.first);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void activate() {
/* 18 */     this.source.init();
/* 19 */     this.second.rotSet(0);
/* 20 */     (VIEW.s()).tools.place((PLACABLE)this.first, this.config);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\UICopier.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */