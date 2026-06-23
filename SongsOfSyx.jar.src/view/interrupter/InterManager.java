/*     */ package view.interrupter;
/*     */ 
/*     */ import init.constant.C;
/*     */ import java.util.Iterator;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.gui.misc.GBox;
/*     */ import view.tool.ToolManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InterManager
/*     */ {
/*  17 */   private final Collection inters = new Collection();
/*  18 */   private Interrupter hovered = null;
/*  19 */   private Rec viewPort = new Rec();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Interrupter i) {
/*  28 */     if (i.addManager != null) {
/*  29 */       throw new RuntimeException(String.valueOf(i));
/*     */     }
/*  31 */     for (Interrupter in : this.inters) {
/*  32 */       in.otherAdd(i);
/*     */     }
/*  34 */     if (i.desturbingfuck)
/*  35 */       for (Interrupter in : this.inters) {
/*  36 */         if (!in.isPersistent() && !in.pinned() && in != i) {
/*  37 */           in.hide();
/*     */         }
/*     */       }  
/*  40 */     if (i.last()) {
/*  41 */       this.inters.add(i);
/*     */     } else {
/*  43 */       this.inters.addFirst(i);
/*     */     } 
/*     */     
/*  46 */     i.addManager = this;
/*     */   }
/*     */   
/*     */   public void disturb() {
/*  50 */     for (Interrupter in : this.inters) {
/*  51 */       if (!in.pinned() && !in.isPersistent())
/*  52 */         in.hide(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void remove(Interrupter interrupter) {
/*  57 */     this.inters.remove(interrupter);
/*  58 */     interrupter.deactivateAction();
/*  59 */     if (this.hovered == interrupter) {
/*  60 */       this.hovered = null;
/*     */     }
/*  62 */     interrupter.addManager = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hoverTimer(double mouseStillTime, GBox text) {
/*  72 */     if (this.hovered != null) {
/*  73 */       this.hovered.hoverTimer(text);
/*  74 */       return false;
/*     */     } 
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, float ds) {
/*  85 */     r.newLayer(true, 0);
/*  86 */     for (Interrupter i : this.inters) {
/*  87 */       if (!i.render(r, ds)) {
/*  88 */         r.newLayer(true, 0);
/*  89 */         return false;
/*     */       } 
/*  91 */       r.newLayer(true, 0);
/*     */     } 
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean click(MButt button) {
/* 103 */     for (Interrupter i : this.inters) {
/* 104 */       if (i == this.hovered) {
/* 105 */         this.hovered.mouseClick(button);
/* 106 */         return false;
/*     */       } 
/*     */       
/* 109 */       if (i.otherClick(button)) {
/* 110 */         return false;
/*     */       }
/*     */     } 
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update(float ds) {
/* 121 */     boolean ret = true;
/* 122 */     for (Interrupter i : this.inters) {
/* 123 */       if (!i.update(ds))
/* 124 */         ret = false; 
/*     */     } 
/* 126 */     for (Interrupter i : this.inters) {
/* 127 */       if (!i.DoWhateverAndallowOthersToDoWhatever()) {
/*     */         break;
/*     */       }
/*     */     } 
/* 131 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public void afterTick() {
/* 136 */     for (Interrupter i : this.inters) {
/* 137 */       i.afterTick();
/*     */     }
/* 139 */     this.viewPort.set(C.DIM());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 149 */     this.hovered = null;
/* 150 */     for (Interrupter i : this.inters) {
/* 151 */       if (i.hover(mCoo, mouseHasMoved)) {
/* 152 */         this.hovered = i;
/* 153 */         return false;
/*     */       } 
/*     */     } 
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 160 */     for (Interrupter i : this.inters) {
/* 161 */       if (!i.pinned()) {
/* 162 */         i.hide();
/* 163 */         if (this.hovered == i)
/* 164 */           this.hovered = null; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isHovered() {
/* 170 */     return (this.hovered != null);
/*     */   }
/*     */   
/*     */   public Rec viewPort() {
/* 174 */     return this.viewPort;
/*     */   }
/*     */   
/*     */   private static class Collection
/*     */     implements Iterable<Interrupter>, Iterator<Interrupter> {
/*     */     private int i;
/* 180 */     private final ArrayList<Interrupter> all = new ArrayList(64);
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 184 */       if (this.i < 0)
/* 185 */         this.i = 0; 
/* 186 */       return (this.i < this.all.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public Interrupter next() {
/* 191 */       if (this.i < 0)
/* 192 */         this.i = 0; 
/* 193 */       return (Interrupter)this.all.get(this.i++);
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Interrupter> iterator() {
/* 198 */       this.i = 0;
/* 199 */       return this;
/*     */     }
/*     */     
/*     */     void add(Interrupter i) {
/* 203 */       this.all.add(i);
/*     */     }
/*     */ 
/*     */     
/*     */     void addFirst(Interrupter i) {
/* 208 */       this.all.insert(0, i);
/* 209 */       if (this.i > 0) {
/* 210 */         this.i--;
/*     */       }
/*     */     }
/*     */     
/*     */     void remove(Interrupter i) {
/* 215 */       int index = this.all.removeOrdered(i);
/* 216 */       if (index < 0)
/* 217 */         throw new RuntimeException(); 
/* 218 */       if (index <= this.i) {
/* 219 */         this.i--;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isGoodTimeToSave() {
/* 225 */     for (Interrupter i : this.inters) {
/* 226 */       if (i instanceof ToolManager) {
/* 227 */         ToolManager t = (ToolManager)i;
/* 228 */         if (t.current() instanceof view.tool.ToolPlacer)
/* 229 */           return false; 
/*     */       } 
/*     */     } 
/* 232 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canSave() {
/* 236 */     for (Interrupter i : this.inters) {
/* 237 */       if (!i.canSave())
/* 238 */         return false; 
/*     */     } 
/* 240 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\InterManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */