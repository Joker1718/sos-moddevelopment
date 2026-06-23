/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.type.HTYPE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.Induvidual;
/*    */ import util.gui.misc.GBox;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public class UISubjects
/*    */ {
/* 12 */   public final UISubjectsList list = new UISubjectsList();
/* 13 */   private final UISubject subject = new UISubject();
/* 14 */   final UISubjectHoverer hoverer = new UISubjectHoverer();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Humanoid current() {
/* 21 */     Humanoid a = this.subject.showing();
/* 22 */     if (a != null)
/* 23 */       return a; 
/* 24 */     return null;
/*    */   }
/*    */   
/*    */   public void hoverInfo(Humanoid h, GBox text) {
/* 28 */     this.hoverer.hover(h, text);
/*    */   }
/*    */   
/*    */   public void hoverInfoSoldier(Induvidual h, GBox text) {
/* 32 */     this.hoverer.hover(h, text);
/*    */   }
/*    */   
/*    */   public void show() {
/* 36 */     this.list.show();
/*    */   }
/*    */   
/*    */   public boolean listActive() {
/* 40 */     return (VIEW.s()).panels.added(this.list);
/*    */   }
/*    */   
/*    */   public boolean shows(Humanoid h) {
/* 44 */     return (current() == h);
/*    */   }
/*    */   
/*    */   public boolean shows(HTYPE t) {
/* 48 */     return (current() != null && current().indu().hType() == t);
/*    */   }
/*    */   
/*    */   public void show(Humanoid h) {
/* 52 */     this.list.show(h);
/* 53 */     this.subject.activate(h, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void showSingle(Humanoid h) {
/* 58 */     this.subject.activate(h, true);
/*    */   }
/*    */   
/*    */   public void showProfession(RoomInstance work) {
/* 62 */     this.list.showProfession(work);
/*    */   }
/*    */   
/*    */   public boolean canShow(Humanoid a) {
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjects.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */