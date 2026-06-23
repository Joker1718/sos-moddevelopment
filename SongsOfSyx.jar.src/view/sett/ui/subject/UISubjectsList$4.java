/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GTableBuilder
/*     */ {
/*     */   public int nrOFEntries() {
/* 164 */     return UISubjectsList.this.li.li.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void click(int index) {
/* 169 */     UISubjectsList.this.selected = index;
/* 170 */     UISubjectsList.this.current = UISubjectsList.this.li.li.get(UISubjectsList.this.selected);
/* 171 */     if (UISubjectsList.this.current instanceof Humanoid && ((Humanoid)UISubjectsList.this.current).canBeClicked()) {
/* 172 */       (VIEW.s()).ui.subjects.show((Humanoid)UISubjectsList.this.current);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doubleClick(int index) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(int index) {
/* 183 */     if (index >= 0) {
/* 184 */       UISubjectsList.this.current = UISubjectsList.this.li.li.get(index);
/* 185 */       if (UISubjectsList.this.current instanceof Humanoid) {
/* 186 */         ((Humanoid)UISubjectsList.this.current).hover(VIEW.hoverBox());
/*     */       } else {
/* 188 */         (VIEW.s()).ui.subjects.hoverInfoSoldier((Induvidual)UISubjectsList.this.current, VIEW.hoverBox());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean selectedIs(int index) {
/* 194 */     return ((VIEW.s()).ui.subjects.current() == UISubjectsList.this.li.li.get(index));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectsList$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */