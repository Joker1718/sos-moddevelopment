/*     */ package util.data;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ public final class DataOLoader
/*     */ {
/* 600 */   DataO<T> old = null;
/*     */   private long[] tmp;
/*     */   private final int longCount;
/*     */   
/*     */   private DataOLoader(FileGetter f) throws IOException {
/* 605 */     boolean isSame = true;
/* 606 */     this.longCount = f.i();
/* 607 */     int kk = f.i();
/* 608 */     int j = isSame & ((this.longCount == paramDataO.longCount()) ? 1 : 0);
/*     */     
/* 610 */     this.old = new DataO<T>(false)
/*     */       {
/*     */         protected long[] data(T t)
/*     */         {
/* 614 */           return DataO.DataOLoader.this.tmp;
/*     */         }
/*     */       };
/*     */     
/*     */     int i;
/* 619 */     for (i = 0; i < kk; i++) {
/* 620 */       String k = f.chars();
/* 621 */       int t = f.i();
/* 622 */       switch (t) {
/*     */         case 1:
/* 624 */           this.old.getClass();
/*     */           break;
/*     */         case 2:
/* 627 */           this.old.getClass();
/*     */           break;
/*     */         case 4:
/* 630 */           this.old.getClass();
/*     */           break;
/*     */         case 8:
/* 633 */           this.old.getClass();
/*     */           break;
/*     */         case 16:
/* 636 */           this.old.getClass();
/*     */           break;
/*     */         case 32:
/* 639 */           this.old.getClass();
/*     */           break;
/*     */         case 64:
/* 642 */           this.old.getClass();
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 647 */     j = (this.old.entries.entries.size() == paramDataO.entries.entries.size()) ? 1 : 0;
/*     */     
/* 649 */     for (i = 0; i < paramDataO.entries.entries.size() && j != 0; i++) {
/*     */       
/* 651 */       if (!((DataO.Entries.Entry)this.old.entries.entries.get(i)).mkey.equals(((DataO.Entries.Entry)paramDataO.entries.entries.get(i)).mkey)) {
/* 652 */         LOG.ln(((DataO.Entries.Entry)this.old.entries.entries.get(i)).mkey + " " + ((DataO.Entries.Entry)this.old.entries.entries.get(i)).mkey);
/* 653 */         j = 0;
/*     */       } 
/*     */     } 
/*     */     
/* 657 */     if (j != 0) {
/* 658 */       this.old = null;
/*     */     } else {
/* 660 */       LOG.ln(String.valueOf(paramDataO));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void wash(T t, long[] oldData) {
/* 665 */     if (this.old == null) {
/* 666 */       for (int i = 0; i < oldData.length; i++) {
/* 667 */         DataO.this.data(t)[i] = oldData[i];
/*     */       }
/*     */       return;
/*     */     } 
/* 671 */     this.tmp = oldData;
/* 672 */     Arrays.fill(DataO.this.data(t), 0L);
/* 673 */     for (DataO<T>.Entries.Entry e : this.old.entries.entries) {
/* 674 */       DataO<T>.Entries.Entry o = (DataO.Entries.Entry)DataO.this.entries.map.get(e.mkey);
/* 675 */       if (o != null && e.type == o.type) {
/* 676 */         o.ii.set(t, e.ii.get(t));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(T t, FileGetter f) {
/* 684 */     if (this.old == null) {
/* 685 */       f.ls(DataO.this.data(t));
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 691 */     this.tmp = new long[this.longCount];
/* 692 */     f.ls(this.tmp);
/*     */ 
/*     */     
/* 695 */     Arrays.fill(DataO.this.data(t), 0L);
/*     */     
/* 697 */     for (DataO<T>.Entries.Entry e : this.old.entries.entries) {
/* 698 */       DataO<T>.Entries.Entry o = (DataO.Entries.Entry)DataO.this.entries.map.get(e.mkey);
/* 699 */       if (o != null && e.type == o.type) {
/* 700 */         o.ii.set(t, e.ii.get(t));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(Object[] tt, FileGetter f) throws IOException {
/* 707 */     int am = f.i();
/*     */     int i;
/* 709 */     for (i = 0; i < am; i++) {
/* 710 */       if (i > tt.length) {
/* 711 */         long[] ll = new long[this.longCount];
/* 712 */         f.ls(ll);
/*     */       } else {
/* 714 */         load((T)tt[i], f);
/*     */       } 
/*     */     } 
/* 717 */     for (i = am; i < tt.length; i++) {
/* 718 */       Arrays.fill(DataO.this.data(tt[i]), 0L);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(LIST<T> tt, FileGetter f) throws IOException {
/* 724 */     int am = f.i(); int i;
/* 725 */     for (i = 0; i < am; i++) {
/* 726 */       if (i > tt.size()) {
/* 727 */         long[] ll = new long[this.longCount];
/* 728 */         f.ls(ll);
/*     */       } else {
/* 730 */         load((T)tt.get(i), f);
/*     */       } 
/*     */     } 
/* 733 */     for (i = am; i < tt.size(); i++)
/* 734 */       Arrays.fill(DataO.this.data(tt.get(i)), 0L); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataO$DataOLoader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */