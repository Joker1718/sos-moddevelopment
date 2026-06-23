/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.type.CRIMES;
/*    */ import init.type.HCLASSES;
/*    */ import init.type.HTYPE;
/*    */ import init.type.HTYPES;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.DicTime;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/*    */     Str str;
/* 75 */     text.add((UISubjectHoverer.this.indu.race()).info.namePosessive);
/* 76 */     text.s().add((UISubjectHoverer.this.hum == null) ? (HTYPES.SOLDIER()).name : UISubjectHoverer.this.hum.title());
/* 77 */     if (UISubjectHoverer.this.hum == null) {
/* 78 */       text.add(',').add(UISubjectHoverer.¤¤yearsOld);
/* 79 */       text.insert(0, (int)(STATS.POP()).age.years.getD(UISubjectHoverer.this.indu));
/*    */     } 
/* 81 */     CharSequence extra = null;
/* 82 */     HTYPE t = UISubjectHoverer.this.indu.hType();
/* 83 */     if (t == HTYPES.SLAVE()) {
/* 84 */       extra = (UISubjectHoverer.this.indu.clas()).name;
/* 85 */     } else if (t == HTYPES.PRISONER()) {
/*    */       
/* 87 */       if (((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(UISubjectHoverer.this.indu)).cl == HCLASSES.SLAVE()) {
/* 88 */         str = Str.TMP.clear().s().add('(').add((HCLASSES.SLAVE()).name).add(')');
/*    */       }
/* 90 */     } else if (t.parent() != t) {
/* 91 */       str = Str.TMP.clear().add((STATS.POP()).age.years.getD(UISubjectHoverer.this.indu), 1).s().add(DicTime.¤¤Years);
/*    */     } 
/*    */     
/* 94 */     if (str != null)
/* 95 */       text.s().add('(').add((CharSequence)str).add(')'); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectHoverer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */