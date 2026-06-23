/*    */ package init.sprite.UI;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import util.spritecomposer.ComposerFonter;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UIFonts
/*    */ {
/*    */   public final Font H2;
/*    */   public final Font H1;
/*    */   public final Font S;
/*    */   public final Font M;
/*    */   public final LIST<Font> all;
/*    */   
/*    */   UIFonts() throws IOException {
/* 27 */     Json json = new Json((PATHS.CONFIG()).init.gets("Charset"));
/* 28 */     CharSequence cs = json.text("CHARS");
/* 29 */     int trail = json.i("SPACING", 0, 32, 0);
/*    */     
/* 31 */     Font.setCharset(cs);
/* 32 */     PATH g = PATHS.SPRITE().getFolder("font");
/*    */     
/* 34 */     KeyMap<Boolean> map = new KeyMap(); byte b; int i;
/*    */     String[] arrayOfString;
/* 36 */     for (i = (arrayOfString = g.getFiles()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 37 */       map.put(s, Boolean.valueOf(true));
/*    */       b++; }
/*    */     
/* 40 */     this.S = get(g, "Small", 2 * trail / 3);
/* 41 */     this.M = get(g, "Medium", trail);
/*    */     
/* 43 */     if (map.containsKey("Header1")) {
/* 44 */       this.H1 = get(g, "Header1", trail);
/*    */     } else {
/* 46 */       this.H1 = this.M;
/*    */     } 
/*    */     
/* 49 */     if (map.containsKey("Header2")) {
/* 50 */       this.H2 = get(g, "Header2", 2 * trail / 3);
/*    */     } else {
/* 52 */       this.H2 = this.M;
/*    */     } 
/*    */ 
/*    */     
/* 56 */     this.all = (LIST<Font>)new ArrayList((Object[])new Font[] { this.H2, this.H1, this.M, 
/* 57 */           this.S });
/*    */   }
/*    */ 
/*    */   
/*    */   private Font get(PATH g, String name, final int trail) throws IOException {
/* 62 */     if (g.exists(name))
/* 63 */       return (new ComposerThings.IFont(g.get(name))
/*    */         {
/*    */           protected Font init(ComposerUtil c, ComposerFonter f)
/*    */           {
/* 67 */             return f.save(0, 0, trail);
/*    */           }
/* 69 */         }).get(trail); 
/* 70 */     return this.M;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIFonts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */