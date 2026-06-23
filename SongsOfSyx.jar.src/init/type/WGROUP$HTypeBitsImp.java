/*     */ package init.type;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HTypeBitsImp
/*     */   implements WGROUP.HTypeBits, Serializable
/*     */ {
/*     */   private static HTypeBitsImp[] specific;
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int[] data;
/*     */   
/*     */   public static WGROUP.HTypeBits specific(WGROUP t) {
/* 136 */     if (specific == null) {
/* 137 */       specific = new HTypeBitsImp[WGROUP.all().size()];
/* 138 */       for (int i = 0; i < WGROUP.all().size(); i++) {
/* 139 */         specific[i] = new HTypeBitsImp(false);
/* 140 */         specific[i].set((WGROUP)WGROUP.all().get(i));
/*     */       } 
/*     */     } 
/* 143 */     return specific[t.index];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HTypeBitsImp(boolean everyone) {
/* 154 */     if (everyone)
/* 155 */       setEveryone(); 
/*     */   }
/*     */   
/*     */   private int[] bits() {
/* 159 */     if (this.data == null) {
/* 160 */       this.data = Alloc.ii((int)Math.ceil(WGROUP.all().size() / 32.0D));
/* 161 */     } else if (this.data.length != Math.ceil(WGROUP.all().size() / 32.0D)) {
/* 162 */       this.data = Alloc.ii((int)Math.ceil(WGROUP.all().size() / 32.0D));
/*     */     } 
/* 164 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int index) {
/* 169 */     int ii = index >>> 5;
/* 170 */     int m = 1 << (index & 0x1F);
/* 171 */     return ((bits()[ii] & m) != 0);
/*     */   }
/*     */   
/*     */   public HTypeBitsImp set(WGROUP type) {
/* 175 */     int index = type.index;
/* 176 */     int ii = index >>> 5;
/* 177 */     int m = 1 << (index & 0x1F);
/* 178 */     bits()[ii] = bits()[ii] | m;
/*     */     
/* 180 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp copy(WGROUP.HTypeBits other) {
/* 184 */     clear();
/* 185 */     for (int i = 0; i < WGROUP.all().size(); i++) {
/* 186 */       if (other.is(i))
/* 187 */         set((WGROUP)WGROUP.all().get(i)); 
/*     */     } 
/* 189 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp setEveryone() {
/* 193 */     int[] bits = bits();
/* 194 */     for (int i = 0; i < bits.length; i++) {
/* 195 */       bits[i] = -1;
/*     */     }
/* 197 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp clear(WGROUP type) {
/* 201 */     int index = type.index;
/* 202 */     int ii = index >>> 5;
/* 203 */     int m = 1 << (index & 0x1F);
/* 204 */     bits()[ii] = bits()[ii] & (m ^ 0xFFFFFFFF);
/* 205 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp clear() {
/* 209 */     int[] bits = bits();
/* 210 */     for (int i = 0; i < bits.length; i++) {
/* 211 */       bits[i] = 0;
/*     */     }
/* 213 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\WGROUP$HTypeBitsImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */