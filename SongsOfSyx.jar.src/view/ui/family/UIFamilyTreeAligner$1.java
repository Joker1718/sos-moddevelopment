/*    */ package view.ui.family;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.PathTile;
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
/*    */   implements Comparator<PathTile>
/*    */ {
/*    */   public int compare(PathTile o1, PathTile o2) {
/* 37 */     int ref1 = o1.x() + o1.y() * SETT.TWIDTH;
/* 38 */     int ref2 = o2.x() + o2.y() * SETT.TWIDTH;
/* 39 */     int p1 = UIFamilyTreeAligner.this.r.parentRef(ref1);
/* 40 */     int p2 = UIFamilyTreeAligner.this.r.parentRef(ref2);
/* 41 */     int v1 = (int)UIFamilyTreeAligner.this.f.getValue2(UIFamilyTreeAligner.this.coo(p1));
/* 42 */     int v2 = (int)UIFamilyTreeAligner.this.f.getValue2(UIFamilyTreeAligner.this.coo(p2));
/* 43 */     return v1 - v2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTreeAligner$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */