/*    */ package game.event.engine;
/*    */ import game.event.actions.EventAction;
/*    */ import game.time.TIME;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.D;
/*    */ import util.text.DicTime;
/*    */ import view.main.VIEW;
/*    */ import view.ui.message.Message;
/*    */ 
/*    */ final class Butt extends CLICKABLE.ClickableAbs {
/* 19 */   private static CharSequence ¤¤timeRemaining = "Time Remaining"; private final EVENT_HANDLER e;
/*    */   
/*    */   static {
/* 22 */     D.ts(Butt.class);
/*    */   }
/*    */   
/*    */   Butt(EVENT_HANDLER e) {
/* 26 */     super(64, 48);
/* 27 */     this.e = e;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 32 */     if (this.e.current() != null) {
/* 33 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 34 */       (this.e.current()).info.icon.renderC(r, this.body.cX(), this.body.cY());
/* 35 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 41 */     if (this.e.current() == null)
/*    */       return; 
/* 43 */     GBox b = (GBox)text;
/* 44 */     b.title((this.e.current()).info.name);
/* 45 */     b.text((this.e.current()).info.desc);
/* 46 */     b.NL();
/* 47 */     if ((this.e.current()).info.showRemaining && (this.e.current()).duration.seconds > 0.0D) {
/* 48 */       b.text(¤¤timeRemaining);
/* 49 */       double t = (this.e.current()).duration.seconds - this.e.timeElapsed();
/* 50 */       int days = (int)(t / TIME.secondsPerDay());
/* 51 */       GText te = b.text();
/* 52 */       if (days > 0) {
/* 53 */         DicTime.setDays((Str)te, days);
/* 54 */         b.add((SPRITE)te);
/* 55 */         te = b.text();
/*    */       } 
/* 57 */       t -= (days * TIME.secondsPerDay());
/* 58 */       DicTime.setHours((Str)te, t / TIME.secondsPerHour());
/* 59 */       b.add((SPRITE)te);
/* 60 */       te = b.text();
/* 61 */       b.NL();
/*    */     } 
/* 63 */     b.NL(8);
/* 64 */     for (EventAction a : (this.e.current()).on_spawn) {
/* 65 */       if (!a.hideUI)
/* 66 */         a.hover(b, this.e.current(), this.e.context()); 
/*    */     } 
/* 68 */     b.NL();
/* 69 */     for (EventAction a : (this.e.current()).on_spawn) {
/* 70 */       if (a.hideUI)
/*    */         continue; 
/* 72 */       CharSequence s = a.problem(this.e.current(), this.e.context());
/* 73 */       if (s != null) {
/* 74 */         b.error(s);
/* 75 */         b.NL();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 83 */     if (this.e.context() == null || this.e.mess() == null)
/*    */       return; 
/* 85 */     VIEW.messages().reopen((Message)this.e.mess());
/* 86 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\Butt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */