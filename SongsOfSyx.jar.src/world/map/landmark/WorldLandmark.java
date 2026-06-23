/*    */ package world.map.landmark;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ 
/*    */ public class WorldLandmark
/*    */ {
/*    */   public final short index;
/* 12 */   public final Str name = new Str(32);
/* 13 */   public final Str description = new Str(256);
/* 14 */   private int size = 0;
/*    */   
/*    */   public short cx;
/*    */   
/*    */   WorldLandmark(int index) {
/* 19 */     this.index = (short)index;
/* 20 */     clear();
/*    */   }
/*    */   public short cy; public byte textSize;
/*    */   public int index() {
/* 24 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   void save(FilePutter f) {
/* 29 */     this.name.save(f);
/*    */     
/* 31 */     this.description.save(f);
/* 32 */     f.i(this.cx).i(this.cy);
/* 33 */     f.i(this.textSize);
/* 34 */     f.i(this.size);
/*    */   }
/*    */ 
/*    */   
/*    */   void load(FileGetter f) throws IOException {
/* 39 */     this.name.load(f);
/* 40 */     this.description.load(f);
/* 41 */     this.cx = (short)f.i();
/* 42 */     this.cy = (short)f.i();
/* 43 */     this.textSize = (byte)f.i();
/* 44 */     this.size = f.i();
/*    */   }
/*    */   
/*    */   void clear() {
/* 48 */     this.name.clear().add(this.index);
/* 49 */     this.description.clear();
/* 50 */     this.cx = -1;
/* 51 */     this.cy = -1;
/* 52 */     this.textSize = -1;
/* 53 */     this.size = 0;
/*    */   }
/*    */   
/*    */   void init(int cx, int cy, int area, int textDir) {
/* 57 */     this.cx = (short)cx;
/* 58 */     this.cy = (short)cy;
/* 59 */     this.textSize = (byte)textDir;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\WorldLandmark.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */