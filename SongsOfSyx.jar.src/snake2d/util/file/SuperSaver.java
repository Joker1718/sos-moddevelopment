/*    */ package snake2d.util.file;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public abstract class SuperSaver<T>
/*    */   implements SAVABLE
/*    */ {
/*    */   private final LIST<T> tt;
/* 12 */   private final KeyMap<T> map = new KeyMap();
/*    */   private Class<?> clas;
/*    */   
/*    */   public SuperSaver(Class<?> clas, LIST<T> tt) {
/* 16 */     this.tt = tt;
/* 17 */     for (T t : tt)
/*    */     {
/* 19 */       this.map.put(key(t), t);
/*    */     }
/* 21 */     this.clas = clas;
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract String key(T paramT);
/*    */ 
/*    */   
/*    */   protected abstract void save(T paramT, FilePutter paramFilePutter);
/*    */   
/*    */   public void save(FilePutter f) {
/* 31 */     f.i(this.tt.size());
/*    */     
/* 33 */     for (int i = 0; i < this.tt.size(); i++) {
/* 34 */       T e = (T)this.tt.get(i);
/* 35 */       f.chars(key(e));
/* 36 */       int pos = f.getPosition();
/* 37 */       f.i(0);
/* 38 */       save(e, f);
/* 39 */       int le = f.getPosition() - pos - 4;
/* 40 */       f.setAtPosition(pos, le);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract void load(T paramT, FileGetter paramFileGetter) throws IOException;
/*    */   
/*    */   public void load(FileGetter f) throws IOException {
/* 48 */     clear();
/* 49 */     int am = f.i();
/*    */     
/* 51 */     for (int i = 0; i < am; i++) {
/* 52 */       String k = f.chars();
/*    */       
/* 54 */       int pos = f.getPosition() + f.i() + 4;
/* 55 */       T e = (T)this.map.get(k);
/* 56 */       if (e != null) {
/* 57 */         load(e, f);
/* 58 */         if (f.getPosition() != pos) {
/* 59 */           LOG.ln(this.clas + " " + k + " " + f.getPosition() + " " + pos + " " + e.getClass().getSimpleName());
/* 60 */           f.setPosition(pos);
/* 61 */           clear(e);
/*    */         } 
/*    */       } else {
/* 64 */         LOG.ln(this.clas + " " + k);
/* 65 */         f.setPosition(pos);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract void clear(T paramT);
/*    */   
/*    */   public void clear() {
/* 73 */     for (int i = 0; i < this.tt.size(); i++) {
/* 74 */       T e = (T)this.tt.get(i);
/* 75 */       clear(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\SuperSaver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */