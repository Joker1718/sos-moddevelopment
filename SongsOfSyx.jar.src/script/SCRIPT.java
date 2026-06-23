/*     */ package script;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.gui.misc.GBox;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface SCRIPT
/*     */ {
/*     */   CharSequence name();
/*     */   
/*     */   CharSequence desc();
/*     */   
/*     */   default void initBeforeGameCreated() {}
/*     */   
/*     */   default void initBeforeGameInited() {}
/*     */   
/*     */   SCRIPT_INSTANCE createInstance();
/*     */   
/*     */   default boolean isSelectable() {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean forceInit() {
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface SCRIPT_INSTANCE
/*     */   {
/*     */     void update(double param1Double);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void save(FilePutter param1FilePutter);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void load(FileGetter param1FileGetter) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default void hoverTimer(double mouseTimer, GBox text) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default void render(Renderer r, float ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default void keyPush(KEYS key) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default void mouseClick(MButt button) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default boolean handleBrokenSavedState() {
/* 136 */       return false;
/*     */     }
/*     */     
/*     */     default void hover(COORDINATE mCoo, boolean mouseHasMoved) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\script\SCRIPT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */