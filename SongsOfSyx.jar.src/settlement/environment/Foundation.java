/*    */ package settlement.environment;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.map.MAP_DOUBLE;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.rnd.HeightMap;
/*    */ import snake2d.util.sets.Bitsmap1D;
/*    */ import util.text.D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Foundation
/*    */   implements MAP_DOUBLE
/*    */ {
/* 21 */   private final Bitsmap1D data = new Bitsmap1D(0, 2, SETT.TAREA);
/* 22 */   private final double II = 0.3333333333333333D;
/*    */   
/* 24 */   public static CharSequence ¤¤name = "Foundation";
/* 25 */   public static CharSequence ¤¤desc = "How well the ground is suited for supported buildings and rooms. Poor isolation will make constructed rooms require more building materials and maintenance.";
/*    */   
/*    */   static {
/* 28 */     D.ts(Foundation.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   final SAVABLE saver;
/*    */ 
/*    */   
/*    */   public double get(int tile) {
/* 37 */     if ((SETT.GROUND()).types.ROCK.is(tile))
/* 38 */       return 0.5D; 
/* 39 */     return 0.3333333333333333D * this.data.get(tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(int tx, int ty) {
/* 44 */     if ((SETT.GROUND()).types.ROCK.is(tx, ty))
/* 45 */       return 0.5D; 
/* 46 */     return 0.3333333333333333D * this.data.get(tx + ty * SETT.TWIDTH);
/*    */   }
/*    */   
/*    */   public void generate() {
/* 50 */     HeightMap h = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 128, 4);
/* 51 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 52 */       double d = h.get(c);
/* 53 */       if (d < 0.5D) {
/* 54 */         d *= d;
/*    */       } else {
/* 56 */         d = Math.sqrt(d);
/* 57 */       }  this.data.set(c.x() + c.y() * SETT.TWIDTH, CLAMP.i((int)Math.round(d * 3.0D), 0, 3));
/*    */     } 
/*    */   }
/*    */   Foundation() {
/* 61 */     this.saver = new SAVABLE()
/*    */       {
/*    */         public void save(FilePutter file)
/*    */         {
/* 65 */           Foundation.this.data.save(file);
/*    */         }
/*    */ 
/*    */         
/*    */         public void load(FileGetter file) throws IOException {
/* 70 */           Foundation.this.data.load(file);
/*    */         }
/*    */         
/*    */         public void clear() {}
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\Foundation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */